package com.dnkilic.gictionary;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.firebase.crash.FirebaseCrash;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TranslationManager {

    private static final String MAKE_TRANSLATE_REQUEST_TAG = "MAKE_TRANSLATE_REQUEST";
    private TranslationListener mResponse;

    public TranslationManager(TranslationListener response) {
        mResponse = response;
    }

    public void makeTranslationRequest(String fromLanguage, String destLanguage, String phrase) {

        if(fromLanguage.equals(destLanguage))
        {
            mResponse.onError("You cant translate identical languages");
        }
        else
        {
            String URL = "https://glosbe.com/gapi_v0_1/translate?";

            /*Log.d("com.dnkilic.gictionary", "Request : " + "from :" + fromLanguage + "\n" +
                    "dest :" + destLanguage + "\n" +
                    "phrase :" + phrase + "\n" +
                    "pretty :" + "true" + "\n" +
                    "format :" + "json");*/

            Uri builtUri = Uri.parse(URL).buildUpon()
                    .appendQueryParameter("from", fromLanguage)
                    .appendQueryParameter("dest", destLanguage)
                    .appendQueryParameter("phrase", phrase)
                    .appendQueryParameter("pretty", "true")
                    .appendQueryParameter("format", "json")
                    .build();

            URL url = null;

            try {
                url = new URL(builtUri.toString());
            } catch (MalformedURLException e) {
                FirebaseCrash.logcat(Log.ERROR, "Translation", "MalformedURLException caught");
                FirebaseCrash.report(e);
                e.printStackTrace();
            }

            JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.GET, url.toString(),

                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {

                                JSONObject json = new JSONObject(response.toString());

                                String result = json.getString("result");

                                if(result.equals("ok"))
                                {
                                    ArrayList<Word> words = new ArrayList<>();

                                    JSONArray tucList = null;

                                    try {
                                        tucList = json.getJSONArray("tuc");
                                    }catch (Exception e)
                                    {
                                        FirebaseCrash.logcat(Log.ERROR, "Searched word can not be found.", "Exception caught");
                                        FirebaseCrash.report(e);
                                        e.printStackTrace();
                                        mResponse.onError("Searched word can not be found.");
                                    }

                                    if(tucList != null)
                                    {
                                        for (int i=0 ; i < tucList.length() ; i++){
                                            JSONObject tuc = tucList.getJSONObject(i);

                                            JSONObject phrase = null;

                                            try {
                                                phrase = tuc.getJSONObject("phrase");
                                            }
                                            catch (Exception e)
                                            {
                                                FirebaseCrash.logcat(Log.ERROR, "getJSONObject(phrase).", "Exception caught");
                                                FirebaseCrash.report(e);
                                                e.printStackTrace();
                                            }

                                            if(phrase != null)
                                            {
                                                JSONArray meanings = null;

                                                try {
                                                    meanings = tuc.getJSONArray("meanings");
                                                }
                                                catch (Exception e){
                                                    FirebaseCrash.logcat(Log.ERROR, "getJSONArray(meanings).", "Exception caught");
                                                    FirebaseCrash.report(e);
                                                    e.printStackTrace();
                                                }

                                                ArrayList<String> meaningList = new ArrayList<>();

                                                if(meanings != null)
                                                {
                                                    for (int j=0 ; j < meanings.length() ; j++)
                                                    {
                                                        JSONObject meaning = meanings.getJSONObject(j);

                                                        if(!meaningList.contains(meaning.getString("text")))
                                                        {
                                                            if(meaning.getString("language").equals(json.getString("dest")))
                                                            {
                                                                meaningList.add(meaning.getString("text"));
                                                            }
                                                        }
                                                    }
                                                }

                                                words.add(new Word(phrase.getString("text"), meaningList));
                                            }
                                            /*else
                                            {
                                                mResponse.onError("Searched word can not be found.");
                                            }*/
                                        }

                                        if(words.isEmpty())
                                        {
                                            mResponse.onError("Searched word can not be found.");
                                        }
                                        else
                                        {
                                            mResponse.onSuccess(words);
                                        }
                                    }
                                    else
                                    {
                                        mResponse.onError("Searched word can not be found.");
                                    }
                                }
                                else
                                {
                                    mResponse.onError("Searched word can not be found.");
                                }
                            } catch (JSONException e) {
                                FirebaseCrash.logcat(Log.ERROR, "General", "Exception caught");
                                FirebaseCrash.report(e);
                                e.printStackTrace();
                                mResponse.onError(e.getMessage());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                            mResponse.onError("Server error occurred");
                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    headers.put("User-agent", System.getProperty("http.agent"));
                    return headers;
                }
            };

            postRequest.setTag(MAKE_TRANSLATE_REQUEST_TAG);
            postRequest.setRetryPolicy(new DefaultRetryPolicy(
                    60000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            AppController.getInstance().addToRequestQueue(postRequest);
        }


    }
}

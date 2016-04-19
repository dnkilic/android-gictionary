package com.dnkilic.gictionary;

import android.net.Uri;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

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
    private TranslationManagerResponse mResponse;

    public TranslationManager(TranslationManagerResponse response) {
        mResponse = response;
    }

    public void makeTranslationRequest(String fromLanguage, String destLanguage, String phrase) {

        String URL = "https://glosbe.com/gapi_v0_1/translate?";

        Log.d("com.dnkilic.gictionary", "Request : " + "from :" + fromLanguage + "\n" +
                "dest :" + destLanguage + "\n" +
                "phrase :" + phrase + "\n" +
                "pretty :" + "true" + "\n" +
                "format :" + "json");

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
                                JSONArray tucList = json.getJSONArray("tuc");

                                for (int i=0 ; i < tucList.length() ; i++){
                                    JSONObject tuc = tucList.getJSONObject(i);
                                    JSONObject phrase = tuc.getJSONObject("phrase");
                                    JSONObject meanings = tuc.getJSONObject("meanings");

                                    ArrayList<String> meaningList = new ArrayList<>();


                                    for (int j=0 ; i < meanings.length() ; j++)
                                    {
                                        JSONObject meaning = tucList.getJSONObject(j);
                                        meaningList.add(meaning.getString("text"));
                                    }

                                    mResponse.onSuccess(new Word(phrase.getString("text"), meaningList));
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            mResponse.onError(e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        mResponse.onError("Bir server hatası oluştu.");
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
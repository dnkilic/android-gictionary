package com.dnkilic.gictionary;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_settings, container, false);

        Language [] spinnerValues = {
                Language.ARABIC,
                Language.ARMENIAN,
                Language.BOSNIAN,
                Language.BULGARIAN,
                Language.CHINESE,
                Language.FRENCH,
                Language.GERMAN,
                Language.GREEK,
                Language.HINDI,
                Language.PERSIAN,
                Language.HEBREW,
                Language.ITALIAN,
                Language.JAPANESE,
                Language.URDU,
                Language.PORTUGUESE,
                Language.RUSSIAN,
                Language.SPANISH,
                Language.SWEDISH,
                Language.TURKISH,
                Language.ENGLISH,
                Language.KURDISH
        };

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String selectedSourceLanguage = sharedPref.getString(getResources().getString(R.string.pref_source_language), "");
        String selectedDestinationLanguage = sharedPref.getString(getResources().getString(R.string.pref_destination_language), "");

        Spinner sourceLanguageSpinner = (Spinner) view.findViewById(R.id.spSourceLang);
        sourceLanguageSpinner.setAdapter(new SpinnerAdapter(getActivity(), R.layout.custom_spinner, R.id.tvLanguage, spinnerValues));

        if(!selectedSourceLanguage.isEmpty())
        {
            for(int i = 0 ; i < spinnerValues.length ; i++)
            {
                if(selectedSourceLanguage.equals(spinnerValues[i].toString()))
                {
                    sourceLanguageSpinner.setSelection(i);
                }
            }
        }

        sourceLanguageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,  int position, long id) {
                String item = adapter.getItemAtPosition(position).toString();
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(getResources().getString(R.string.pref_source_language), item);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });

        Spinner destinationLanguageSpinner = (Spinner) view.findViewById(R.id.spDestinationLang);
        destinationLanguageSpinner.setAdapter(new SpinnerAdapter(getActivity(), R.layout.custom_spinner, R.id.tvLanguage, spinnerValues));

        if(!selectedDestinationLanguage.isEmpty())
        {
            for(int i = 0 ; i < spinnerValues.length ; i++)
            {
                if(selectedDestinationLanguage.equals(spinnerValues[i].toString()))
                {
                    destinationLanguageSpinner.setSelection(i);
                }
            }
        }

        destinationLanguageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String item = adapter.getItemAtPosition(position).toString();
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(getResources().getString(R.string.pref_destination_language), item);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

package com.dnkilic.gictionary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_settings, container, false);

        String [] spinnerValues =
                {
                        "ARABIC",
                        "ARMENIAN",
                        "BOSNIAN",
                        "BULGARIAN",
                        "CHINESE",
                        "ENGLISH",
                        "FRENCH",
                        "GERMAN",
                        "GREEK",
                        "HEBREW",
                        "HINDI",
                        "ITALIAN",
                        "JAPANESE",
                        "KURDISH",
                        "PERSIAN",
                        "PORTUGUESE",
                        "RUSSIAN",
                        "SPANISH",
                        "SWEDISH",
                        "TURKISH",
                        "URDU"
                };

        Spinner sourceLanguageSpinner = (Spinner) view.findViewById(R.id.spSourceLang);
        sourceLanguageSpinner.setAdapter(new SpinnerAdapter(getActivity(), R.layout.custom_spinner, R.id.tvLanguage, spinnerValues));
        sourceLanguageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                //String item = adapter.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        Spinner destinationLanguageSpinner = (Spinner) view.findViewById(R.id.spDestinationLang);
        destinationLanguageSpinner.setAdapter(new SpinnerAdapter(getActivity(), R.layout.custom_spinner, R.id.tvLanguage, spinnerValues));
        destinationLanguageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                //String item = adapter.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
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

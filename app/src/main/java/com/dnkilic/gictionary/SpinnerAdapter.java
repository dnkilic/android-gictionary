package com.dnkilic.gictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter<Language> {

    private Language [] mLanguages;
    private Context mContext;

    public SpinnerAdapter(Context context, int resource, int textViewResourceId, Language[] objects) {
        super(context, resource, textViewResourceId, objects);
        mContext = context;
        mLanguages = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.custom_spinner, parent, false);

        ImageView ivFlag = (ImageView) view.findViewById(R.id.ivFlag);
        TextView tvLanguage = (TextView) view.findViewById(R.id.tvLanguage);

        switch (mLanguages[position])
        {
            case ARABIC:
                ivFlag.setImageResource(R.drawable.flag_arabia);
                tvLanguage.setText("Arabic");
                break;
            case ARMENIAN:
                ivFlag.setImageResource(R.drawable.flag_armenia);
                tvLanguage.setText("Armenian");
                break;
            case BOSNIAN:
                ivFlag.setImageResource(R.drawable.flag_bosnia);
                tvLanguage.setText("Bosnian");
                break;
            case BULGARIAN:
                ivFlag.setImageResource(R.drawable.flag_bulgaria);
                tvLanguage.setText("Bulgarian");
                break;
            case CHINESE:
                ivFlag.setImageResource(R.drawable.flag_china);
                tvLanguage.setText("Chinese");
                break;
            case ENGLISH:
                ivFlag.setImageResource(R.drawable.flag_uk);
                tvLanguage.setText("English");
                break;
            case FRENCH:
                ivFlag.setImageResource(R.drawable.flag_france);
                tvLanguage.setText("French");
                break;
            case GERMAN:
                ivFlag.setImageResource(R.drawable.flag_germany);
                tvLanguage.setText("German");
                break;
            case GREEK:
                ivFlag.setImageResource(R.drawable.flag_greece);
                tvLanguage.setText("Greek");
                break;
            case HEBREW:
                ivFlag.setImageResource(R.drawable.flag_israel);
                tvLanguage.setText("Hebrew");
                break;
            case HINDI:
                ivFlag.setImageResource(R.drawable.flag_india);
                tvLanguage.setText("Hindi");
                break;
            case ITALIAN:
                ivFlag.setImageResource(R.drawable.flag_italy);
                tvLanguage.setText("Italy");
                break;
            case JAPANESE:
                ivFlag.setImageResource(R.drawable.flag_japan);
                tvLanguage.setText("Japanese");
                break;
            case KURDISH:
                ivFlag.setImageResource(R.drawable.flag_kurdistan);
                tvLanguage.setText("Kurdish");
                break;
            case PERSIAN:
                ivFlag.setImageResource(R.drawable.flag_iran);
                tvLanguage.setText("Persian");
                break;
            case PORTUGUESE:
                ivFlag.setImageResource(R.drawable.flag_portugal);
                tvLanguage.setText("Portugal");
                break;
            case RUSSIAN:
                ivFlag.setImageResource(R.drawable.flag_russia);
                tvLanguage.setText("Russian");
                break;
            case SPANISH:
                ivFlag.setImageResource(R.drawable.flag_spain);
                tvLanguage.setText("Spanish");
                break;
            case SWEDISH:
                ivFlag.setImageResource(R.drawable.flag_sweden);
                tvLanguage.setText("Swedish");
                break;
            case TURKISH:
                ivFlag.setImageResource(R.drawable.flag_turkey);
                tvLanguage.setText("Turkish");
                break;
            case URDU:
                ivFlag.setImageResource(R.drawable.flag_pakistan);
                tvLanguage.setText("Urdu");
                break;
        }

        return view;
    }
}

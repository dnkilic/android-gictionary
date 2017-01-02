package com.dnkilic.gictionary;

import android.content.res.Resources;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ViewManager {

    private View mView;

    private RadioGroup toLanguageRadioGroup;
    private RadioGroup fromLanguageRadioGroup;

    private HorizontalScrollView svSourceLanguages;
    private HorizontalScrollView svDestinationLanguages;

    private String mSelectedSourceLanguage;
    private String mSelectedDestinationLanguage;

    private TextView tvSourceLanguage;
    private TextView tvDestinationLanguage;

    private Resources mResources;

    public ViewManager(View view, Resources resources) {
        mView = view;
        mResources = resources;
    }

    public void initializeButtons(final String selectedSourceLanguage, final String selectedDestinationLanguage)
    {
        fromLanguageRadioGroup = (RadioGroup) mView.findViewById(R.id.fromLanguageRadioGroup);
        fromLanguageRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setSelectedSourceLanguage(getLanguageAsString(checkedId));
            }
        });
        toLanguageRadioGroup = (RadioGroup) mView.findViewById(R.id.toLanguageRadioGroup);
        toLanguageRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setSelectedDestinationLanguage(getLanguageAsString(checkedId));
            }
        });

        tvSourceLanguage = (TextView) mView.findViewById(R.id.tvSelectedSourceLanguage);
        tvDestinationLanguage = (TextView) mView.findViewById(R.id.tvSelectedDestinationLanguage);

        svSourceLanguages = (HorizontalScrollView) mView.findViewById(R.id.svSourceLanguages);
        if(!selectedSourceLanguage.isEmpty())
        {
            svSourceLanguages.postDelayed(new Runnable() {
                public void run() {
                    svSourceLanguages.smoothScrollBy(getSelectedButton(selectedSourceLanguage, mView).getLeft(), 0);
                }
            }, 100L);

            fromLanguageRadioGroup.check(getSelectedButton(selectedSourceLanguage, mView).getId());
            setSelectedSourceLanguage(selectedSourceLanguage);
        }

        svDestinationLanguages = (HorizontalScrollView) mView.findViewById(R.id.svDestinationLanguages);
        if(!selectedDestinationLanguage.isEmpty())
        {
            svDestinationLanguages.postDelayed(new Runnable() {
                public void run() {
                    svDestinationLanguages.smoothScrollBy(getSelectedDestinationButton(selectedDestinationLanguage, mView).getLeft(), 0);
                }
            }, 100L);

            toLanguageRadioGroup.check(getSelectedDestinationButton(selectedDestinationLanguage, mView).getId());
            setSelectedDestinationLanguage(selectedDestinationLanguage);
        }

        mSelectedSourceLanguage = selectedSourceLanguage;
        mSelectedDestinationLanguage = selectedDestinationLanguage;
    }

    public void setSelectedSourceLanguage(String language)
    {
        String selectedLanguage = "";

        switch (language)
        {
            case "ar":
                selectedLanguage = mResources.getString(R.string.language_ar);
                break;
            case "hy":
                selectedLanguage = mResources.getString(R.string.language_hy);
                break;
            case "bs":
                selectedLanguage = mResources.getString(R.string.language_bs);
                break;
            case "bg":
                selectedLanguage = mResources.getString(R.string.language_bg);
                break;
            case "zh":
                selectedLanguage = mResources.getString(R.string.language_zh);
                break;
            case "en":
                selectedLanguage = mResources.getString(R.string.language_en);
                break;
            case "fr":
                selectedLanguage = mResources.getString(R.string.language_fr);
                break;
            case "de":
                selectedLanguage = mResources.getString(R.string.language_de);
                break;
            case "el":
                selectedLanguage = mResources.getString(R.string.language_el);
                break;
            case "hi":
                selectedLanguage = mResources.getString(R.string.language_hi);
                break;
            case "fa":
                selectedLanguage = mResources.getString(R.string.language_fa);
                break;
            case "he":
                selectedLanguage = mResources.getString(R.string.language_he);
                break;
            case "it":
                selectedLanguage = mResources.getString(R.string.language_it);
                break;
            case "ja":
                selectedLanguage = mResources.getString(R.string.language_ja);
                break;
            case "ur":
                selectedLanguage = mResources.getString(R.string.language_ur);
                break;
            case "pt":
                selectedLanguage = mResources.getString(R.string.language_pt);
                break;
            case "ru":
                selectedLanguage = mResources.getString(R.string.language_ru);
                break;
            case "ku":
                selectedLanguage = mResources.getString(R.string.language_ku);
                break;
            case "es":
                selectedLanguage = mResources.getString(R.string.language_es);
                break;
            case "sv":
                selectedLanguage = mResources.getString(R.string.language_sv);
                break;
            case "tr":
                selectedLanguage = mResources.getString(R.string.language_tr);
                break;
            default:
                selectedLanguage = language;
        }

        tvSourceLanguage.setText(selectedLanguage);
    }

    public void setSelectedDestinationLanguage(String language)
    {
        String selectedLanguage = "";

        switch (language)
        {
            case "ar":
                selectedLanguage = mResources.getString(R.string.language_ar);
                break;
            case "hy":
                selectedLanguage = mResources.getString(R.string.language_hy);
                break;
            case "bs":
                selectedLanguage = mResources.getString(R.string.language_bs);
                break;
            case "bg":
                selectedLanguage = mResources.getString(R.string.language_bg);
                break;
            case "zh":
                selectedLanguage = mResources.getString(R.string.language_zh);
                break;
            case "en":
                selectedLanguage = mResources.getString(R.string.language_en);
                break;
            case "fr":
                selectedLanguage = mResources.getString(R.string.language_fr);
                break;
            case "de":
                selectedLanguage = mResources.getString(R.string.language_de);
                break;
            case "el":
                selectedLanguage = mResources.getString(R.string.language_el);
                break;
            case "hi":
                selectedLanguage = mResources.getString(R.string.language_hi);
                break;
            case "fa":
                selectedLanguage = mResources.getString(R.string.language_fa);
                break;
            case "he":
                selectedLanguage = mResources.getString(R.string.language_he);
                break;
            case "it":
                selectedLanguage = mResources.getString(R.string.language_it);
                break;
            case "ja":
                selectedLanguage = mResources.getString(R.string.language_ja);
                break;
            case "ur":
                selectedLanguage = mResources.getString(R.string.language_ur);
                break;
            case "pt":
                selectedLanguage = mResources.getString(R.string.language_pt);
                break;
            case "ru":
                selectedLanguage = mResources.getString(R.string.language_ru);
                break;
            case "ku":
                selectedLanguage = mResources.getString(R.string.language_ku);
                break;
            case "es":
                selectedLanguage = mResources.getString(R.string.language_es);
                break;
            case "sv":
                selectedLanguage = mResources.getString(R.string.language_sv);
                break;
            case "tr":
                selectedLanguage = mResources.getString(R.string.language_tr);
                break;
            default:
                selectedLanguage = language;
        }

        tvDestinationLanguage.setText(selectedLanguage);
    }

    public Language getSelectedSourceLanguage()
    {
        return getLanguage(fromLanguageRadioGroup.getCheckedRadioButtonId());
    }

    public Language getSelectedDestinationLanguage()
    {
        return getLanguage(toLanguageRadioGroup.getCheckedRadioButtonId());
    }

    private RadioButton getSelectedButton(String selection, View v)
    {
        RadioButton rbSelected = null;

        switch (selection)
        {
            case "ar":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromArabic);
                break;
            case "hy":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromArmenian);
                break;
            case "bs":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromBosnian);
                break;
            case "bg":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromBulgarian);
                break;
            case "zh":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromChinese);
                break;
            case "en":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromEnglish);
                break;
            case "fr":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromFrench);
                break;
            case "de":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromGerman);
                break;
            case "el":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromGreek);
                break;
            case "hi":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromHindi);
                break;
            case "fa":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromPersian);
                break;
            case "he":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromHebrew);
                break;
            case "it":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromItalian);
                break;
            case "ja":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromJapanese);
                break;
            case "ur":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromUrdu);
                break;
            case "pt":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromPortuguese);
                break;
            case "ru":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromRussian);
                break;
            case "ku":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromKurdish);
                break;
            case "es":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromSpanish);
                break;
            case "sv":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromSwedish);
                break;
            case "tr":
                rbSelected = (RadioButton) v.findViewById(R.id.btnFromTurkish);
                break;
        }
        return rbSelected;
    }

    private RadioButton getSelectedDestinationButton(String selection, View v)
    {
        RadioButton rbSelected = null;

        switch (selection)
        {
            case "ar" :
                rbSelected = (RadioButton) v.findViewById(R.id.btnToArabic);
                break;
            case "hy":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToArmenian);
                break;
            case "bs":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToBosnian);
                break;
            case "bn":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToBulgarian);
                break;
            case "zh":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToChinese);
                break;
            case "en":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToEnglish);
                break;
            case "fr":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToFrench);
                break;
            case "de":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToGerman);
                break;
            case "el":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToGreek);
                break;
            case "hi":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToHindi);
                break;
            case "fa":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToPersian);
                break;
            case "he":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToHebrew);
                break;
            case "it":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToItalian);
                break;
            case "ja":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToJapanese);
                break;
            case "ur":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToUrdu);
                break;
            case "pt":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToPortuguese);
                break;
            case "ru":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToRussian);
                break;
            case "ku":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToKurdish);
                break;
            case "es":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToSpanish);
                break;
            case "sv":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToSwedish);
                break;
            case "tr":
                rbSelected = (RadioButton) v.findViewById(R.id.btnToTurkish);
                break;
        }
        return rbSelected;
    }

    private Language getLanguage(int radioId)
    {
        Language selectedLanguage;
        switch (radioId)
        {
            case R.id.btnFromArabic:
                selectedLanguage = Language.ARABIC;
                break;
            case R.id.btnFromArmenian:
                selectedLanguage = Language.ARMENIAN;
                break;
            case R.id.btnFromBosnian:
                selectedLanguage = Language.BOSNIAN;
                break;
            case R.id.btnFromBulgarian:
                selectedLanguage = Language.BULGARIAN;
                break;
            case R.id.btnFromChinese:
                selectedLanguage = Language.CHINESE;
                break;
            case R.id.btnFromEnglish:
                selectedLanguage = Language.ENGLISH;
                break;
            case R.id.btnFromFrench:
                selectedLanguage = Language.FRENCH;
                break;
            case R.id.btnFromGerman:
                selectedLanguage = Language.GERMAN;
                break;
            case R.id.btnFromGreek:
                selectedLanguage = Language.GREEK;
                break;
            case R.id.btnFromHindi:
                selectedLanguage = Language.HINDI;
                break;
            case R.id.btnFromPersian:
                selectedLanguage = Language.PERSIAN;
                break;
            case R.id.btnFromHebrew:
                selectedLanguage = Language.HEBREW;
                break;
            case R.id.btnFromItalian:
                selectedLanguage = Language.ITALIAN;
                break;
            case R.id.btnFromJapanese:
                selectedLanguage = Language.JAPANESE;
                break;
            case R.id.btnFromUrdu:
                selectedLanguage = Language.URDU;
                break;
            case R.id.btnFromPortuguese:
                selectedLanguage = Language.PORTUGUESE;
                break;
            case R.id.btnFromRussian:
                selectedLanguage = Language.RUSSIAN;
                break;
            case R.id.btnFromKurdish:
                selectedLanguage = Language.KURDISH;
                break;
            case R.id.btnFromSpanish:
                selectedLanguage = Language.SPANISH;
                break;
            case R.id.btnFromSwedish:
                selectedLanguage = Language.SWEDISH;
                break;
            case R.id.btnFromTurkish:
                selectedLanguage = Language.TURKISH;
                break;
            case R.id.btnToArabic:
                selectedLanguage = Language.ARABIC;
                break;
            case R.id.btnToArmenian:
                selectedLanguage = Language.ARMENIAN;
                break;
            case R.id.btnToBosnian:
                selectedLanguage = Language.BOSNIAN;
                break;
            case R.id.btnToBulgarian:
                selectedLanguage = Language.BULGARIAN;
                break;
            case R.id.btnToChinese:
                selectedLanguage = Language.CHINESE;
                break;
            case R.id.btnToEnglish:
                selectedLanguage = Language.ENGLISH;
                break;
            case R.id.btnToFrench:
                selectedLanguage = Language.FRENCH;
                break;
            case R.id.btnToGerman:
                selectedLanguage = Language.GERMAN;
                break;
            case R.id.btnToGreek:
                selectedLanguage = Language.GREEK;
                break;
            case R.id.btnToHindi:
                selectedLanguage = Language.HINDI;
                break;
            case R.id.btnToPersian:
                selectedLanguage = Language.PERSIAN;
                break;
            case R.id.btnToHebrew:
                selectedLanguage = Language.HEBREW;
                break;
            case R.id.btnToItalian:
                selectedLanguage = Language.ITALIAN;
                break;
            case R.id.btnToJapanese:
                selectedLanguage = Language.JAPANESE;
                break;
            case R.id.btnToUrdu:
                selectedLanguage = Language.URDU;
                break;
            case R.id.btnToPortuguese:
                selectedLanguage = Language.PORTUGUESE;
                break;
            case R.id.btnToRussian:
                selectedLanguage = Language.RUSSIAN;
                break;
            case R.id.btnToSpanish:
                selectedLanguage = Language.SPANISH;
                break;
            case R.id.btnToSwedish:
                selectedLanguage = Language.SWEDISH;
                break;
            case R.id.btnToTurkish:
                selectedLanguage = Language.TURKISH;
                break;
            case R.id.btnToKurdish:
                selectedLanguage = Language.KURDISH;
                break;
            default:
                selectedLanguage = Language.ENGLISH;
                break;
        }
        return selectedLanguage;
    }

    private String getLanguageAsString(int radioId)
    {
        String selectedLanguage = null;
        switch (radioId)
        {
            case R.id.btnFromArabic:
                selectedLanguage = mResources.getString(R.string.language_ar);
                break;
            case R.id.btnFromArmenian:
                selectedLanguage = mResources.getString(R.string.language_hy);
                break;
            case R.id.btnFromBosnian:
                selectedLanguage = mResources.getString(R.string.language_bs);
                break;
            case R.id.btnFromBulgarian:
                selectedLanguage = mResources.getString(R.string.language_bg);
                break;
            case R.id.btnFromChinese:
                selectedLanguage = mResources.getString(R.string.language_zh);
                break;
            case R.id.btnFromEnglish:
                selectedLanguage = mResources.getString(R.string.language_en);
                break;
            case R.id.btnFromFrench:
                selectedLanguage = mResources.getString(R.string.language_fr);
                break;
            case R.id.btnFromGerman:
                selectedLanguage = mResources.getString(R.string.language_de);
                break;
            case R.id.btnFromGreek:
                selectedLanguage = mResources.getString(R.string.language_el);
                break;
            case R.id.btnFromHindi:
                selectedLanguage = mResources.getString(R.string.language_hi);
                break;
            case R.id.btnFromPersian:
                selectedLanguage = mResources.getString(R.string.language_fa);
                break;
            case R.id.btnFromHebrew:
                selectedLanguage = mResources.getString(R.string.language_he);
                break;
            case R.id.btnFromItalian:
                selectedLanguage = mResources.getString(R.string.language_it);
                break;
            case R.id.btnFromJapanese:
                selectedLanguage = mResources.getString(R.string.language_ja);
                break;
            case R.id.btnFromUrdu:
                selectedLanguage = mResources.getString(R.string.language_ur);
                break;
            case R.id.btnFromPortuguese:
                selectedLanguage = mResources.getString(R.string.language_pt);
                break;
            case R.id.btnFromRussian:
                selectedLanguage = mResources.getString(R.string.language_ru);
                break;
            case R.id.btnFromKurdish:
                selectedLanguage = mResources.getString(R.string.language_ku);
                break;
            case R.id.btnFromSpanish:
                selectedLanguage = mResources.getString(R.string.language_es);
                break;
            case R.id.btnFromSwedish:
                selectedLanguage = mResources.getString(R.string.language_sv);
                break;
            case R.id.btnFromTurkish:
                selectedLanguage = mResources.getString(R.string.language_tr);
                break;
            case R.id.btnToArabic:
                selectedLanguage = mResources.getString(R.string.language_ar);
                break;
            case R.id.btnToArmenian:
                selectedLanguage = mResources.getString(R.string.language_hy);
                break;
            case R.id.btnToBosnian:
                selectedLanguage = mResources.getString(R.string.language_bs);
                break;
            case R.id.btnToBulgarian:
                selectedLanguage = mResources.getString(R.string.language_bg);
                break;
            case R.id.btnToChinese:
                selectedLanguage = mResources.getString(R.string.language_zh);
                break;
            case R.id.btnToEnglish:
                selectedLanguage = mResources.getString(R.string.language_en);
                break;
            case R.id.btnToFrench:
                selectedLanguage = mResources.getString(R.string.language_fr);
                break;
            case R.id.btnToGerman:
                selectedLanguage = mResources.getString(R.string.language_de);
                break;
            case R.id.btnToGreek:
                selectedLanguage = mResources.getString(R.string.language_el);
                break;
            case R.id.btnToHindi:
                selectedLanguage = mResources.getString(R.string.language_hi);
                break;
            case R.id.btnToPersian:
                selectedLanguage = mResources.getString(R.string.language_fa);
                break;
            case R.id.btnToHebrew:
                selectedLanguage = mResources.getString(R.string.language_he);
                break;
            case R.id.btnToItalian:
                selectedLanguage = mResources.getString(R.string.language_it);
                break;
            case R.id.btnToJapanese:
                selectedLanguage = mResources.getString(R.string.language_ja);
                break;
            case R.id.btnToUrdu:
                selectedLanguage = mResources.getString(R.string.language_ur);
                break;
            case R.id.btnToPortuguese:
                selectedLanguage = mResources.getString(R.string.language_pt);
                break;
            case R.id.btnToRussian:
                selectedLanguage = mResources.getString(R.string.language_ru);
                break;
            case R.id.btnToKurdish:
                selectedLanguage = mResources.getString(R.string.language_ku);
                break;
            case R.id.btnToSpanish:
                selectedLanguage = mResources.getString(R.string.language_es);
                break;
            case R.id.btnToSwedish:
                selectedLanguage = mResources.getString(R.string.language_sv);
                break;
            case R.id.btnToTurkish:
                selectedLanguage = mResources.getString(R.string.language_tr);
                break;
        }

        return selectedLanguage;
    }
}

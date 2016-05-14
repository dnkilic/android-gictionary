package com.dnkilic.gictionary;

import android.view.View;
import android.widget.RadioGroup;

public class ViewManager {

    private View mView;

    RadioGroup toLanguageRadioGroup;
    RadioGroup fromLanguageRadioGroup;

    public ViewManager(View view) {
        mView = view;
    }

    public void initializeButtons()
    {
        fromLanguageRadioGroup = (RadioGroup) mView.findViewById(R.id.fromLanguageRadioGroup);
        toLanguageRadioGroup = (RadioGroup) mView.findViewById(R.id.toLanguageRadioGroup);
    }

    public Language getSelectedSourceLanguage()
    {
        return getLanguage(fromLanguageRadioGroup.getCheckedRadioButtonId());
    }

    public Language getSelectedDestinationLanguage()
    {
        return getLanguage(toLanguageRadioGroup.getCheckedRadioButtonId());
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
}

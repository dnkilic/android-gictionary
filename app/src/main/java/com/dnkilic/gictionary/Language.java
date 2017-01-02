package com.dnkilic.gictionary;

public enum Language {

    ARABIC("ar"),
    ARMENIAN("hy"),
    BOSNIAN("bs"),
    BULGARIAN("bg"),
    CHINESE("zh"),
    FRENCH("fr"),
    GERMAN("de"),
    GREEK("el"),
    HINDI("hi"),
    PERSIAN("fa"),
    HEBREW("he"),
    ITALIAN("it"),
    JAPANESE("ja"),
    URDU("ur"),
    PORTUGUESE("pt"),
    RUSSIAN("ru"),
    SPANISH("es"),
    SWEDISH("sv"),
    TURKISH("tr"),
    ENGLISH("en"),
    KURDISH("ku");

    private String mLanguage;

    Language(String language)
    {
        mLanguage = language;
    }

    @Override
    public String toString()
    {
        return mLanguage;
    }
}


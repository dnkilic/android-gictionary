package com.dnkilic.gictionary;

public enum Language {

    ENGLISH("en"),
    TURKISH("tr"),
    FRENCH("fr"),
    GERMAN("de"),
    ARABIC("ar"),
    BOSNIAN("bs"),
    BULGARIAN("bg"),
    PERSIAN("fa"),
    ITALIAN("it"),
    KURDISH("ku"),
    ARMENIAN("hy"),
    SWEDISH("sv"),
    SPANISH("es");

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


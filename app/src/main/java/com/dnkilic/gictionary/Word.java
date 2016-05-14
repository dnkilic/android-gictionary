package com.dnkilic.gictionary;

import java.util.ArrayList;

public class Word {

    String mText;
    ArrayList<String> mMeaningList;

    public Word(String text, ArrayList<String> meaningList)
    {
        mText = text;
        mMeaningList = meaningList;
    }

    public String getWord()
    {
        return mText;
    }

    public ArrayList<String> getMeaningList()
    {
        return mMeaningList;
    }
}

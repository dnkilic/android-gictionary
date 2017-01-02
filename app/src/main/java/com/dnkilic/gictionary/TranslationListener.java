package com.dnkilic.gictionary;


import java.util.ArrayList;

public interface TranslationListener {

    void onSuccess(ArrayList<Word> words);
    void onError(String localError);
}

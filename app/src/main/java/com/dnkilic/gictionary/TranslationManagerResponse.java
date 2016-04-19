package com.dnkilic.gictionary;


public interface TranslationManagerResponse {

    void onSuccess(Word word);
    void onError(String localError);
}

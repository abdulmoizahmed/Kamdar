package com.example.moizahmed.test1.Model;

/**
 * Created by Moiz Ahmed on 2/5/2016.
 */
public class Language {
    private int languageId;
    private static Language language;


    public static synchronized Language getInstance(){

        if(language == null){

            language = new Language();
        }

        return language;

    }

    public Language(){
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int spinner) {
        languageId = spinner;
    }
}

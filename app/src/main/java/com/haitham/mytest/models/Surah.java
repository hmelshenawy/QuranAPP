package com.haitham.mytest.models;

import com.google.gson.annotations.SerializedName;

public class Surah {

    private int number, numberOfAyahs;

    private String name, englishName, englishTranslation, revelationType;

    public Surah() {

        //Empty constractor required

    }


    public Surah(int number, int numberOfAyahs, String name, String englishName
            , String englishTranslation, String revelationType) {

        this.number = number;
        this.numberOfAyahs = numberOfAyahs;
        this.name = name;
        this.englishName = englishName;
        this.englishTranslation = englishTranslation;
        this.revelationType = revelationType;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfAyahs() {
        return numberOfAyahs;
    }

    public void setNumberOfAyahs(int numberOfAyahs) {
        this.numberOfAyahs = numberOfAyahs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        this.englishTranslation = englishTranslation;
    }

    public String getRevelationType() {
        return revelationType;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }
}

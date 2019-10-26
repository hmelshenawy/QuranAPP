package com.haitham.mytest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuranPage {

    private int number;

    @SerializedName("ayahs")
    private List<Ayah> AyahsList;

    public QuranPage(int number, List<Ayah> ayahsList) {
        this.number = number;
        AyahsList = ayahsList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Ayah> getAyahsList() {
        return AyahsList;
    }

    public void setAyahsList(List<Ayah> ayahsList) {
        AyahsList = ayahsList;
    }
}

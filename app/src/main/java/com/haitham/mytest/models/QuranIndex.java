package com.haitham.mytest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuranIndex {

    private int code;

    private String status;

    @SerializedName("data")
    private List<Surah> surahList;

    public QuranIndex() {
    }

    public QuranIndex(int code, String status, List<Surah> surahList) {
        this.code = code;
        this.status = status;
        this.surahList = surahList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Surah> getSurahList() {
        return surahList;
    }

    public void setSurahList(List<Surah> surahList) {
        this.surahList = surahList;
    }
}

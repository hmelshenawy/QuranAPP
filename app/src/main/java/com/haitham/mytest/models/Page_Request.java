package com.haitham.mytest.models;

import com.google.gson.annotations.SerializedName;

public class Page_Request {

    private int code;

    private String status;

    @SerializedName("data")
    private QuranPage quranPage;

    public Page_Request(int code, String status, QuranPage quranPage) {
        this.code = code;
        this.status = status;
        this.quranPage = quranPage;
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

    public QuranPage getQuranPage() {
        return quranPage;
    }

    public void setQuranPage(QuranPage quranPage) {
        this.quranPage = quranPage;
    }
}

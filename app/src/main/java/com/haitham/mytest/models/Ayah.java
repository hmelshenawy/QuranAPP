package com.haitham.mytest.models;

public class Ayah {

    private int number, numberInSurah, juz, page, hizbQuarter, manzil, ruku;

    private String text;

    private boolean sajda;

    private Surah surah;


    public Ayah() {

        //Empty constructor required

    }

    public Ayah(int number, int numberInSurah, int juz, int page, int hizbQuarter
            , int manzil, int ruku, String text, boolean sajda, Surah surah) {

        this.number = number;
        this.numberInSurah = numberInSurah;
        this.juz = juz;
        this.page = page;
        this.hizbQuarter = hizbQuarter;
        this.manzil = manzil;
        this.ruku = ruku;
        this.text = text;
        this.sajda = sajda;
        this.surah = surah;

    }

    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }


    public int getNumberInSurah() {
        return numberInSurah;
    }


    public void setNumberInSurah(int numberInSurah) {
        this.numberInSurah = numberInSurah;
    }


    public int getJuz() {
        return juz;
    }


    public void setJuz(int juz) {
        this.juz = juz;
    }


    public int getPage() {
        return page;
    }


    public void setPage(int page) {
        this.page = page;
    }


    public int getHizbQuarter() {
        return hizbQuarter;
    }


    public void setHizbQuarter(int hizbQuarter) {
        this.hizbQuarter = hizbQuarter;
    }


    public int getManzil() {
        return manzil;
    }


    public void setManzil(int manzil) {
        this.manzil = manzil;
    }


    public int getRuku() {
        return ruku;
    }


    public void setRuku(int ruku) {
        this.ruku = ruku;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public boolean isSajda() {
        return sajda;
    }


    public void setSajda(boolean sajda) {
        this.sajda = sajda;
    }


    public Surah getSurah() {
        return surah;
    }


    public void setSurah(Surah surah) {
        this.surah = surah;
    }
}

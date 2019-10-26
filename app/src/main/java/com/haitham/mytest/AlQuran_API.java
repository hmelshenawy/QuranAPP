package com.haitham.mytest;

import com.haitham.mytest.models.Page_Request;
import com.haitham.mytest.models.QuranIndex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AlQuran_API {

    @GET("surah")
    Call<QuranIndex> getSuraIndex();

    @GET("page/{id}/quran-uthmani")
    Call<Page_Request> getPage_Request(@Path("id") int id);
}

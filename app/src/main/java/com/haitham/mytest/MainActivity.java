package com.haitham.mytest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.haitham.mytest.Adapters.QuranIndex_Adapter;
import com.haitham.mytest.models.QuranIndex;
import com.haitham.mytest.models.Surah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.SystemClock;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView_IndexList;
    QuranIndex_Adapter adapter;

    String str="";
    String text="";

    String quran ="https://api.alquran.cloud/v1/surah";
    String page = "https://api.alquran.cloud/v1/page/1/quran-uthmani";
    String baseURL = "https://api.alquran.cloud/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView_IndexList= findViewById(R.id.lv_sura);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        AlQuran_API alQuranApi = retrofit.create(AlQuran_API.class);


        if (internet_connection()){

            call_Quran_Index(alQuranApi);

        }
        else {

            showAlert();
        }
    }


    private void call_Quran_Index(AlQuran_API alQuranApi) {

        Call<QuranIndex> call = alQuranApi.getSuraIndex();

        call.enqueue(new Callback<QuranIndex>() {
            @Override
            public void onResponse(Call<QuranIndex> call, Response<QuranIndex> response) {

                if (response.isSuccessful()){

                    //if request successful show quran index

                    QuranIndex quranIndex = response.body();

                    List<Surah> surahsList =  quranIndex.getSurahList();

                    adapter = new QuranIndex_Adapter(MainActivity.this, surahsList);

                    recyclerView_IndexList.setAdapter(adapter);

                    recyclerView_IndexList.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<QuranIndex> call, Throwable t) {

                System.out.println("thrwable "+t.getMessage());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    boolean internet_connection(){

        //Check if connected to internet, output accordingly

        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }


    void showAlert(){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Check internet Connection");
        alert.setTitle("Quran App");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();

    }


    public String getQuran(String input){

        String[] strA = input.split(" ");

        for (int i = 0; i < strA.length; i++) {

            str = strA[i];
            str = str.replace("\\","");
            String[] arr = str.split("u");

            for(int j = 1; j < arr.length; j++){
                int hexVal = Integer.parseInt(arr[j], 16);
                text += (char)hexVal;

            }
            text += " ";
        }
        return text;
    }
}

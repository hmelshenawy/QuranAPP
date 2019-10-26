package com.haitham.mytest;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.haitham.mytest.models.Ayah;
import com.haitham.mytest.models.Page_Request;
import com.haitham.mytest.models.QuranPage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PageFragment extends Fragment {

    TextView textView, tv_Juza, tv_Sura, tv_Page_Number;

    String baseURL = "https://api.alquran.cloud/v1/";

    AlQuran_API alQuranApi;

    public PageFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_page, container, false);

        textView = view.findViewById(R.id.textview1);
        tv_Juza = view.findViewById(R.id.tv_Page_Juza);
        tv_Sura = view.findViewById(R.id.tv_Page_Sura);
        tv_Page_Number = view.findViewById(R.id.tv_page_Number);

        String suraText = getArguments().getString("page");
        textView.setText("");

        int i = getArguments().getInt("i");

        if (internet_connection()) {

            Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            alQuranApi = retrofit.create(AlQuran_API.class);

            show_Page(i);

        }else { showAlert(); }
        return view;
    }

    private void show_Page(int i) {

        Call<Page_Request> call = alQuranApi.getPage_Request(i);

        call.enqueue(new Callback<Page_Request>() {
            @Override
            public void onResponse(Call<Page_Request> call, Response<Page_Request> response) {

                if (response.isSuccessful()){

                   Page_Request page_request =  response.body();
                  QuranPage quranPage = page_request.getQuranPage();
                  List<Ayah> ayahsList =  quranPage.getAyahsList();

                  // set page number and juz and sura name at the top of the page

                  tv_Juza.setText( "الجزء " + arabicNumber( ayahsList.get( 0 ).getJuz() ) );
                  tv_Sura.setText( ayahsList.get( 0 ).getSurah().getName() );
                  tv_Page_Number.setText( arabicNumber( quranPage.getNumber() ) + "" );

                  StringBuilder stringBuilder = new StringBuilder();

                  //for loop to add the page text(ayah text and ayah number) to string builder

                    for (int i = 0; i <ayahsList.size() ; i++) {

                        // if it is the opening of the sura adding the sura name to the string builder

                        if (ayahsList.get(i).getNumberInSurah() == 1){

                            stringBuilder.append("\n"+ ayahsList.get(i).getSurah().getName()+"\n");
                        }

                        stringBuilder.append(ayahsList.get(i).getText() + " ﴿"  //۝
                        + arabicNumber(ayahsList.get(i).getNumberInSurah()) + "﴾ " );

                    }

                    String suraText= stringBuilder.toString();
                    suraText = suraText.replace("بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ",  "بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ" + "\n");

                    textView.append(suraText);

                }
            }

            @Override
            public void onFailure(Call<Page_Request> call, Throwable t) {

                // if GET request failed

                System.out.println("page throwable "+t.getMessage());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    boolean internet_connection(){
        //Check if connected to internet, output accordingly
        ConnectivityManager cm = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }


    void showAlert(){

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity().getBaseContext());
        alert.setMessage("Check internet Connection");
        alert.setTitle("Quran App");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }


    public String arabicNumber(int i){

        StringBuilder builder = new StringBuilder();
        String r = String.valueOf(i);
        char[] c = r.toCharArray();

        for (int j=0; j<c.length; j++){

            String s = "";

            switch ( Integer.parseInt(String.valueOf(c[j])) ) {

                case 0: {
                    s = "٠";
                }
                break;
                case 1: {
                    s = "١";
                }
                break;
                case 2: {
                    s = "٢";
                }
                break;
                case 3: {
                    s = "٣";
                }
                break;
                case 4: {
                    s = "٤";
                }
                break;
                case 5: {
                    s = "٥";
                }
                break;
                case 6: {
                    s = "٦";
                }
                break;
                case 7: {
                    s = "٧";
                }
                break;
                case 8: {
                    s = "٨";
                }
                break;
                case 9: {
                    s = "٩";
                }
                break;
            }

            builder.append(s);
        }

        return builder.toString();
    }


}

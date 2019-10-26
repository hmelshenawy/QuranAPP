package com.haitham.mytest;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class QuranPagerAdapter extends FragmentStatePagerAdapter {

    String suraPage;
    PageFragment pageFragment;

    public QuranPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        pageFragment = new PageFragment();
        System.out.println(position);
        int i = 604-position;
        Bundle bundle = new Bundle();
        bundle.putString("page", "Page : "+i);
        bundle.putInt("i", i);
        pageFragment.setArguments(bundle);



        return pageFragment;
    }

    @Override
    public int getCount() {
        return 604;
    }


}

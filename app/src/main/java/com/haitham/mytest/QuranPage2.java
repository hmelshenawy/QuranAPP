package com.haitham.mytest;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

public class QuranPage2 extends AppCompatActivity {

    ViewPager pager;
    QuranPagerAdapter quranPagerAdapter;
    int pageNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_page2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().hide();

        pager= findViewById(R.id.mpager);
        pager.setPageMargin(10);
        quranPagerAdapter = new QuranPagerAdapter(getSupportFragmentManager());

        Intent intent = getIntent();
        int i = intent.getIntExtra("position", 1);


        if (i ==0 ){pageNumber = 1; }
        else if (i == 1){pageNumber=2; }
        else if (i == 2){pageNumber=50; }
        else if (i == 3){pageNumber=77; }
        else if (i == 4){pageNumber=106; }
        else if (i == 5){pageNumber=128; }
        else if (i == 6){pageNumber=151; }
        else if (i == 7){pageNumber=177; }
        else if (i == 8){pageNumber=187; }
        else if (i == 9){pageNumber=208; }
        else if (i == 10){pageNumber=221; }
        else if (i == 11){pageNumber=235; }
        else if (i == 12){pageNumber=249; }
        else if (i == 13){pageNumber=255; }
        else if (i == 14){pageNumber=262; }
        else if (i == 15){pageNumber=267; }
        else if (i == 16){pageNumber=282; }
        else if (i == 17){pageNumber=293; }
        else if (i == 18){pageNumber=305; }
        else if (i == 19){pageNumber=312; }
        else if (i == 20){pageNumber=322; }
        else if (i == 21){pageNumber=332; }
        else if (i == 22){pageNumber=342; }
        else if (i == 23){pageNumber=350; }
        else if (i == 24){pageNumber=359; }
        else if (i == 25){pageNumber=367; }
        else if (i == 26){pageNumber=377; }
        else if (i == 27){pageNumber=385; }
        else if (i == 28){pageNumber=396; }
        else if (i == 29){pageNumber=404; }
        else if (i == 30){pageNumber=411; }
        else if (i == 31){pageNumber=415; }


        pager.setAdapter(quranPagerAdapter);
        pager.setCurrentItem(604-pageNumber);


    }

}

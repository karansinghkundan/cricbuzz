package com.example.cricbuzzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class match extends AppCompatActivity {

    private String url = "https://cricapi.com/api/cricket?apikey=Y1eNDLtLGzYog7iD5wdG4MWH6T22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
    }
}

package com.example.cricbuzzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    int[] Images = {R.drawable.dhoni,R.drawable.virat,R.drawable.hardik};

    String[] name = {"Virat kholi", "Dhoni","Hardik"};

    String[] Description = {"Batsman", "Bowler", "AllRounder"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,loginActivity.class));
            }
        },3000);

        ListView listView = (ListView)findViewById(R.id.listView);

    }
}

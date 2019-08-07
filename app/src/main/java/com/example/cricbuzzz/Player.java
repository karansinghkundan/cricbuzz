package com.example.cricbuzzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Player extends AppCompatActivity {

    int[] Images = {R.drawable.dhoni,R.drawable.virat,R.drawable.hardik};

    String[] name = {"Virat kholi", "Dhoni","Hardik"};

    String[] Description = {"Batsman", "Bowler", "AllRounder"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);






    }
}

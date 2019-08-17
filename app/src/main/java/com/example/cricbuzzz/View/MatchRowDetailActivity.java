package com.example.cricbuzzz.View;

import android.content.Intent;
import android.os.Bundle;

import com.example.cricbuzzz.Model.Matches;
import com.example.cricbuzzz.R;
import com.example.cricbuzzz.View.HomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MatchRowDetailActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_row_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView =findViewById(R.id.textDetail);

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", 0);
        Log.d("Position class:",String.valueOf(position));
        //textView.setText(HomeActivity.matchesArrayList.get(position).toString());
        Matches match = HomeActivity.matchesArrayList.get(position);
        String id = match.getId();


    }

}

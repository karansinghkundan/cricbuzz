package com.example.cricbuzzz.Model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.cricbuzzz.R;

public class Team extends Activity implements AdapterView.OnItemClickListener {
    ListView listView;
    static public String[] countries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        listView = (ListView) findViewById(R.id.list_item);

        countries = getResources().getStringArray(R.array.countries);

        ListAdapter adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adp);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:

        }
        Intent intent = new Intent(this, team_players.class);
        intent.putExtra("Position", i);
        intent.putExtra("CountryName", countries[i]);
        startActivity(intent);
        finish();
    }
}
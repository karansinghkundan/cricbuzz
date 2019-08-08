package com.example.cricbuzzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import static com.example.cricbuzzz.R.id.logout;

public class Team extends Activity implements AdapterView.OnItemClickListener {
    ListView listView;
    static public String[] countries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        listView = (ListView) findViewById(R.id.list_item);
        /*Bundle mBundle = getIntent().getExtras();

        if (mBundle!= null)
        {
            String Country = mBundle.getString("CountryName");
            if(Country.equalsIgnoreCase("India"))
            {
            Coun = getResources().getStringArray(R.array.Ind);
            }
            else if (Country.equalsIgnoreCase("England");
            {
                Coun = getResources().getStringArray(R.array.Eng);
            }
        }
        */

        countries = getResources().getStringArray(R.array.countries);

        ListAdapter adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adp);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("POSITIONS -->>>>>>>> ", " : " + i);
        Log.d("COUNTRIES -->>>>>>>> ", " : " + countries[i]);
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
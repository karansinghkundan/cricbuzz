package com.example.cricbuzzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class team_players extends AppCompatActivity {
    ListView listView;
    String[] teamPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_players);
        listView = (ListView) findViewById(R.id.list_item);
        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("Position");
        switch (position)
        {
            case 0:
                teamPlayers = getResources().getStringArray(R.array.INDIA);
                break;
            case 1:
                teamPlayers = getResources().getStringArray(R.array.AUSTRALIA);
                break;
            case 2:
                teamPlayers = getResources().getStringArray(R.array.ENGLAND);
                break;
            case 3:
                teamPlayers = getResources().getStringArray(R.array.SOUTH_AFRICA);
                break;
            case 4:
                teamPlayers = getResources().getStringArray(R.array.BANGLADESH);
                break;
            case 5:
                teamPlayers = getResources().getStringArray(R.array.INDIA);
                break;
            case 6:
                teamPlayers = getResources().getStringArray(R.array.PAKISTAN);
                break;
            case 7:
                teamPlayers = getResources().getStringArray(R.array.WEST_INDIES);
                break;

        }
        ListAdapter adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,teamPlayers);
        listView.setAdapter(adp);
    }
}

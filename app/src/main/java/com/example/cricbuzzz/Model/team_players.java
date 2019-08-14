package com.example.cricbuzzz.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.cricbuzzz.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class team_players extends AppCompatActivity {
    ListView listView;
    String[] teamPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_players);
        listView = (ListView) findViewById(R.id.list_item);
        Bundle bundle = getIntent().getExtras();

        if(getIntent().getStringExtra("SHOWALLTEAMS")!=null)
        {
            List temp = new ArrayList<String>();
            for(String player :  getResources().getStringArray(R.array.INDIA))
            {
                temp.add(player);
            }
            for(String player :  getResources().getStringArray(R.array.BANGLADES))
            {
                temp.add(player);
            }
            for(String player :  getResources().getStringArray(R.array.AUSTRALIA))
            {
                temp.add(player);
            }
            for(String player :  getResources().getStringArray(R.array.SOUTH_AFRICA))
            {
                temp.add(player);
            }
            for(String player :  getResources().getStringArray(R.array.ENGLAND))
            {
                temp.add(player);
            }
            for(String player :  getResources().getStringArray(R.array.WEST_INDIES))
            {
                temp.add(player);
            }
            for(String player :  getResources().getStringArray(R.array.New_ZEALAND))
            {
                temp.add(player);
            }
            for(String player :  getResources().getStringArray(R.array.PAKISTAN))
            {
                temp.add(player);
            }
            teamPlayers = new String[temp.size()];
            Iterator iter = temp.iterator();
            int i=0;
            while(iter.hasNext())
            {
                teamPlayers[i++] = (String) iter.next();
            }
        }




        else {
            int position = bundle.getInt("Position");
            switch (position) {
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
                    teamPlayers = getResources().getStringArray(R.array.BANGLADES);
                    break;
                case 5:
                    teamPlayers = getResources().getStringArray(R.array.New_ZEALAND);
                    break;
                case 6:
                    teamPlayers = getResources().getStringArray(R.array.PAKISTAN);
                    break;
                case 7:
                    teamPlayers = getResources().getStringArray(R.array.WEST_INDIES);
                    break;

            }
        }
        ListAdapter adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,teamPlayers);
        listView.setAdapter(adp);
    }
}

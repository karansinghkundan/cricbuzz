package com.example.cricbuzzz.View;

import android.content.Intent;
import android.os.Bundle;

import com.example.cricbuzzz.Controler.MatchAdapter;
import com.example.cricbuzzz.Controler.MatchRow;
import com.example.cricbuzzz.Model.Matches;
import com.example.cricbuzzz.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MatchesListActivity extends AppCompatActivity implements MatchAdapter.onMatchListener {
    private RecyclerView recyclerView;
    private MatchAdapter mAdapter;

    ImageView imageView;
    //DataStore mDataStore;
    Button mButton;
    private List<MatchRow> MatchRowList = new ArrayList<>();
    public static ArrayList<Matches> staticMatchesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MatchesListActivity.staticMatchesList = HomeActivity.matchesArrayList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recyclerView);
        mAdapter = new MatchAdapter(this, MatchRowList, (MatchAdapter.onMatchListener) this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMatchListData();

    }

    private void prepareMatchListData()
    {
        for(Matches matches : staticMatchesList)
    { MatchRow MatchRow = new MatchRow(matches.getMatch_date(),matches.getTeam1(),matches.getTeam2());
    MatchRowList.add(MatchRow);
    }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(this, MatchRowDetailActivity.class);
        intent.putExtra("Position",position);
        startActivity(intent);
    }
}

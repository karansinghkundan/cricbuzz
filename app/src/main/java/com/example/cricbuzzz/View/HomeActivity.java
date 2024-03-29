package com.example.cricbuzzz.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.example.cricbuzzz.Controler.Camera;
import com.example.cricbuzzz.Controler.DataStore;
import com.example.cricbuzzz.Model.Matches;
import com.example.cricbuzzz.Model.Team;
import com.example.cricbuzzz.Model.team_players;
import com.example.cricbuzzz.Controler.PhoneCall;
import com.example.cricbuzzz.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    DataStore mDataStore;
    public static ArrayList<Matches> matchesArrayList ;
    FragmentTransaction fragmentTransaction;
    public static Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mDataStore = new DataStore(HomeActivity.this);
        mDataStore.processJSON();
        matchesArrayList = mDataStore.getMatchesArrayList();
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setTitle("CRICSTAR");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeActivity/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(HomeActivity.this, MediaActivity.class));

        } else if (id == R.id.nav_team) {
            startActivity(new Intent(HomeActivity.this, Team.class));


        } else if (id == R.id.nav_player) {
            Intent i = new Intent(HomeActivity.this, team_players.class);
            i.putExtra("SHOWALLTEAMS","SHOWALL");
            startActivity(i);

        } else if (id == R.id.nav_tools) {
            startActivity(new Intent(HomeActivity.this, MatchesListActivity.class));


        } else if (id == R.id.nav_share){

            startActivity(new Intent(HomeActivity.this, PhoneCall.class));


        } else if (id == R.id.nav_send) {
            startActivity(new Intent(HomeActivity.this, Camera.class));

        }

         else if (id == R.id.action_LOGOUT) {
            startActivity(new Intent(HomeActivity.this, loginActivity.class));
        }
        else if(id == R.id.about_us)
        {
            startActivity(new Intent(HomeActivity.this, AboutUs_Activity.class));

        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

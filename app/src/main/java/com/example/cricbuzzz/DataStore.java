package com.example.cricbuzzz;
/*
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SlidingDrawer;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DataStore {

    private ArrayList<User> MatchesArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) toolbar.findViewById(R.id.nav_player);
        setC(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewBy(R.id.action_LOGOUT);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.menu_home, R.string.menu_home);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Process JSON
        this.processJSON();
    }

    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("UserList.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int count = is.read(buffer);
            is.close();
            Log.d("-- COUNT --", String.format("%d Bytes", count));
            json = new String(buffer, "UTF8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    private void setContentView(int activity_main) {
    }

    private void processJSON() {
        String jsonString = this.loadJSONFromAsset();
        if (jsonString != null) {
            try {
                JSONArray mJSONArray = new JSONArray(jsonString);
                userArrayList = new ArrayList<>();

                for (int i = 0; i < mJSONArray.length(); i++) {

                    User mUser = this.getMatchObjectFromJSON()(mJSONArray.getJSONObject(i));
                    MatchesArrayList.add(mUser);
                    Log.d("-- JSON -- ", mUser.toString());

                    /*
                    JSONObject mJSONObject = mJSONArray.getJSONObject(i);

                    if(mJSONObject.has("id"))

                        int id = mJSONObject.getInt("id");
                    }

                    String name = mJSONObject.getString("name");

                    Log.d("-- JSON -- ", name);

                    //Read Address JSON Object
                    JSONObject mAddress = mJSONObject.getJSONObject("address");

                    String city = mAddress.getString("city");
                    Log.d("-- JSON -- ", name + " : " + city);
                    */
                /*}


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

    private User getMatchObjectFromJSON(JSONObject userJsonObject) throws JSONException
    {
        long id = userJsonObject.getLong(User.KEY_ID);
        String name = userJsonObject.getString("name");
        String username = userJsonObject.getString("username");
        String email = userJsonObject.getString("email");
}


*/

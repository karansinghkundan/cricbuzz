package com.example.cricbuzzz.Controler;

import android.content.Context;
import android.util.Log;

import com.example.cricbuzzz.Model.Address;
import com.example.cricbuzzz.Model.Geo;
import com.example.cricbuzzz.Model.Matches;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataStore
{
    Context context;
    public ArrayList<Matches> matchesArrayList ;


    public DataStore(Context context)
    {
        this.context = context;
    }

    public String loadJSONFromAsset() {

        String json;
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int count = is.read(buffer);
            is.close();
            json = new String(buffer, "UTF8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void processJSON()
    {
        String jsonString = this.loadJSONFromAsset();
        if (jsonString != null)
        {
            try {
                JSONArray mJSONArray = new JSONArray(jsonString);
                matchesArrayList = new ArrayList<Matches>();

                for (int i = 0; i < mJSONArray.length(); i++) {

                    Matches mMatches = getMatchObjectFromJSON(mJSONArray.getJSONObject(i));
                    matchesArrayList.add(mMatches);
                }
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

     public Matches getMatchObjectFromJSON(JSONObject userJsonObject) throws JSONException
    {

        Boolean matchStarted = userJsonObject.getBoolean("matchStarted");
        String matchDate = userJsonObject.getString("match_date");
        String team1 = userJsonObject.getString("team1");
        String team2 = userJsonObject.getString("team2");
        String team1Score = userJsonObject.getString("team1_score");
        String team2Score = userJsonObject.getString("team2_score");
        String message = userJsonObject.getString("Message");
        String ManofMatch = userJsonObject.getString("MoM");
        //Address
        JSONObject jsonObject = userJsonObject.getJSONObject("address");
        String street = jsonObject.getString("street");
        String suite = jsonObject.getString("suite");
        String city = jsonObject.getString("city");
        String zipcode = jsonObject.getString("zipcode");

//geo
        JSONObject jsonObjectGeo = jsonObject.getJSONObject("geo");
        String lat = jsonObjectGeo.getString("lat");
        String lng = jsonObjectGeo.getString("lng");

        Geo geoObj = new Geo(lat,lng);
        Address addressObj = new Address(street,suite,city,zipcode,geoObj);
        Matches matchobj = new Matches(matchStarted,matchDate,team1,team2,team1Score,team2Score,message,ManofMatch,addressObj);
        Log.d("Match Obj : ---->> ",matchobj.toString());
        return matchobj;
    }

    public ArrayList<Matches> getMatchesArrayList() {
        return matchesArrayList;
    }
}

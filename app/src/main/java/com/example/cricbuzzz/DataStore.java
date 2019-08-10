package com.example.cricbuzzz;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataStore {


        Context context;
        public ArrayList<Matches> mMatches ;

        public ArrayList<Matches> getmMatches() {
            return mMatches;
        }

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
                    mMatches = new ArrayList<Matches>();

                    for (int i = 0; i < mJSONArray.length(); i++) {

                        Matches mMatches = getMatchesObjectFromJSON(mJSONArray.getJSONObject(i));
                        mMatches.add(mMatches);
                    }
                }
                catch(JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }

        public Matches getMatchesObjectFromJSON(JSONObject userJsonObject) throws JSONException
        {
            String matchStarted = userJsonObject.getString("matchStarted");
            String team1 = userJsonObject.getString("team1");

            ArrayList<Matches> mMatches = this.mMatches;
            return Matches;
        }

    }


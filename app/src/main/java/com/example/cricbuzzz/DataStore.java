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
    public ArrayList<ArrayList<Matches>> matchesArrayList ;
    private Object Matches;

    public ArrayList<ArrayList<Matches>> getmSpaceXFlightList() {
        return matchesArrayList;
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
                matchesArrayList = new ArrayList<ArrayList<Matches>>();

                for (int i = 0; i < mJSONArray.length(); i++) {

                    Matches matches = getFlightObjectFromJSON(mJSONArray.getJSONObject(i));
                    matchesArrayList.add(matchesArrayList);
                }
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    public Matches getFlightObjectFromJSON(JSONObject userJsonObject) throws JSONException
    {
        String flight_number = userJsonObject.getString("flight_number");
        String mission_name = userJsonObject.getString("mission_name");
        String upcoming = userJsonObject.getString("upcoming");
        String launch_year = userJsonObject.getString("launch_year");
        String launch_window = userJsonObject.getString("launch_window");
        String details = userJsonObject.getString("details");
        JSONObject rocket = new JSONObject(userJsonObject.getJSONObject("rocket").toString());
        String rocket_id = rocket.getString("rocket_id");
        String rocket_name = rocket.getString("rocket_name");
        String rocket_type = rocket.getString("rocket_type");
        JSONObject launchSite = new JSONObject(userJsonObject.getJSONObject("launch_site").toString());
        String site_id = launchSite.getString("site_id");
        String site_name = launchSite.getString("site_name");
        String site_name_long = launchSite.getString("site_name_long");
        JSONObject links = new JSONObject(userJsonObject.getJSONObject("links").toString());
        String mission_patch = links.getString("mission_patch");
        String mission_patch_small = links.getString("mission_patch_small");
        String article_link = links.getString("article_link");
        String wikipedia = links.getString("wikipedia");
        String video_link = links.getString("video_link");
        SpaceXFlight mSpaceXFlight = new SpaceXFlight();
        mSpaceXFlight.setFlight_number(flight_number);
        mSpaceXFlight.setMission_name(mission_name);
        mSpaceXFlight.setUpcoming(upcoming);
        mSpaceXFlight.setLaunch_year(launch_year);
        mSpaceXFlight.setLaunch_window(launch_window);
        mSpaceXFlight.setDetails(details);
        Rocket mRocket = new Rocket();
        mRocket.setRocket_id(rocket_id);
        mRocket.setRocket_name(rocket_name);
        mRocket.setRocket_type(rocket_type);
        mSpaceXFlight.setRocket(mRocket);
        LaunchSite mLaunchSite = new LaunchSite();
        mLaunchSite.setSite_id(site_id);
        mLaunchSite.setSite_name(site_name);
        mLaunchSite.setSite_name_long(site_name_long);
        mSpaceXFlight.setLaunchSite(mLaunchSite);
        Links mLinks = new Links();
        mLinks.setMission_patch(mission_patch);
        mLinks.setMission_patch_small(mission_patch_small);
        mLinks.setArticle_link(article_link);
        mLinks.setWikipedia(wikipedia);
        mLinks.setVideo_link(video_link);
        mSpaceXFlight.setLinks(mLinks);

        return Matches;
    }
}

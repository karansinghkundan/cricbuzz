package com.example.cricbuzzz.Model;

public class Geo {


    public static final String KEY_LAT = "lat";
    public static final String KEY_LNG = "lng";

    private String lat;
    private String lng;

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public static String getKeyLat() {
        return KEY_LAT;
    }

    public static String getKeyLng() {
        return KEY_LNG;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }


    @Override
    public String toString() {
        return "Geo{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}

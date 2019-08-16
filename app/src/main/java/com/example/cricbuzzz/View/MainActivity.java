package com.example.cricbuzzz.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cricbuzzz.R;

public class MainActivity extends AppCompatActivity {


    /*LocationManager mLocationManager;
    private static final String TAG = "MainActivity";

    TextView tvLong;

    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {

            Log.e(TAG, "onLocationChanged: "+location.getLatitude() );
            //your code

            String a = String.valueOf(location.getLatitude());
            String bn = String.valueOf(location.getLongitude());

            Log.e(TAG, "onLocationChanged: "+a +"      "+bn  );

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, loginActivity.class));
            }
        },2000);



        //mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000,
               // 100, mLocationListener);
    }
}

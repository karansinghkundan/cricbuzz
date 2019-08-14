package com.example.cricbuzzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.sax.Element;
import android.view.View;
import android.widget.Button;

public class AboutUs_ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_us_);
        Button button = (Button) findViewById(R.id.rateus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://apps.apple.com/in/app/cricbuzz-cricket-scores-news/id360466413")));
                }
                catch (ActivityNotFoundException e)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://apps.apple.com/in/app/cricbuzz-cricket-scores-news/id360466413")));

                }

            }
        });



    }
}

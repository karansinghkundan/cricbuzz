package com.example.cricbuzzz.View;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.cricbuzzz.R;

import java.util.concurrent.TimeUnit;

public class MediaActivity extends AppCompatActivity {



    Button btnPlay, btnStop;
    MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();

    SeekBar seekBarProgress;
    TextView txtDuration;

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        seekBarProgress = (SeekBar)findViewById(R.id.seekBarProgress);
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnStop = (Button)findViewById(R.id.btnStop);

        videoView = findViewById(R.id.videoView);

        //Create MediaPlayer
        mediaPlayer = MediaPlayer.create(getApplicationContext(),
                R.raw.abc);
        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();
        seekBarProgress.setMax((int) finalTime);


        txtDuration = (TextView)findViewById(R.id.txtDuration);

        btnPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Play Audio File
//                mediaPlayer.start();
//                seekBarProgress.setProgress((int)startTime);
//                myHandler.postDelayed(UpdateSongTime,100);

                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.abc);
                videoView.setVideoURI(uri);

                videoView.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mediaPlayer.stop();
                videoView.pause();

            }
        });
    }

    private Runnable UpdateSongTime = new Runnable()
    {
        public void run()
        {
            startTime = mediaPlayer.getCurrentPosition();
            txtDuration.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekBarProgress.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}

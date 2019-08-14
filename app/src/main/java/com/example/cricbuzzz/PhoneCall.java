package com.example.cricbuzzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PhoneCall extends AppCompatActivity {

    TextView txt_PhoneNumber;
    Button buttoncall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);


        buttoncall = (Button)findViewById(R.id.buttoncall);
        txt_PhoneNumber = findViewById(R.id.txt);

        buttoncall.setOnClickListener(new View.OnClickListener() {
            private void requestOnPermisson() {
                ActivityCompat.requestPermissions(PhoneCall.this, new String[]{Manifest.permission.CALL_PHONE}, 1);


            }

            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_CALL);
                String number = txt_PhoneNumber.getText().toString();

                if (number.trim().isEmpty()) {
                    Toast.makeText(PhoneCall.this, "phone call invalid", Toast.LENGTH_SHORT
                    );
                } else {
                    intentCall.setData(Uri.parse("tel:" + number));

                }
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(PhoneCall.this, "please grant permission", Toast.LENGTH_SHORT);
                    requestOnPermisson();
                } else {
                    startActivity(intentCall);
                }
            }
        });




}
    }


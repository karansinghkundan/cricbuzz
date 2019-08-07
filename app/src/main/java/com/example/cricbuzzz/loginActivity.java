package com.example.cricbuzzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtEmail,edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.button);
        edtEmail = findViewById(R.id.editText);
        edtPass = findViewById(R.id.editText2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(edtEmail.getText().toString().equals("admin@gmail.com") && edtPass.getText().toString().equals("admin123")){

                        startActivity(new Intent(loginActivity.this,Home.class));
                    }else{
                        //wrong password
                    }

            }
        });
    }
}

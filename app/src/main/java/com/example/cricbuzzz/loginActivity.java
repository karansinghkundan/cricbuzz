package com.example.cricbuzzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                String emailAddress = edtEmail.getText().toString().trim();
                if (edtPass.getText().toString().length() < 6) {
                    edtPass.setError("password minimum contain 6 character");
                    edtPass.requestFocus();
                }
                if (edtPass.getText().toString().equals("")) {
                    edtPass.setError("please enter password");
                    edtPass.requestFocus();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                    edtEmail.setError("please enter valid email address");
                    edtEmail.requestFocus();
                }
                if (edtEmail.getText().toString().equals("")) {
                    edtEmail.setError("please enter email address");
                    edtEmail.requestFocus();
                }
            }
        });
    }
}

package com.example.cricbuzzz.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cricbuzzz.Controler.DataStore;
import com.example.cricbuzzz.R;

public class loginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtEmail,edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DataStore dataStore = new DataStore(this);
        dataStore.processJSON();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.button);
        edtEmail = findViewById(R.id.edtemail);
        edtPass = findViewById(R.id.edtpassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if(edtEmail.getText().toString().trim().length() == 0){
                        edtEmail.setError("Enter a valid Email");
                        showDialogBox();
                    }
                    else if(edtPass.getText().toString().trim().length() == 0){
                        edtPass.setError("Enter Password");
                    }

                    if(edtEmail.getText().toString().equals("admin@gmail.com") && edtPass.getText().toString().equals("admin123")){
                        startActivity(new Intent(loginActivity.this, HomeActivity.class));
                        finish();
                    }
                    else
                        {



                }


            }
        });
    }

    private void showDialogBox() {

          AlertDialog alertDialog = new AlertDialog.Builder(loginActivity.this)
                .setTitle("Invalid")
                .setMessage("Please enter valid details")

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();


    }
}

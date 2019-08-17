package com.example.cricbuzzz.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.cricbuzzz.Controler.DataStore;
import com.example.cricbuzzz.Model.DBUser;
import com.example.cricbuzzz.Model.User;
import com.example.cricbuzzz.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class loginActivity extends AppCompatActivity {

    SharedPreferences mSharedpreferences;
    SharedPreferences.Editor mEditor;
    ArrayList<User> mUsersArrayList;
    @BindView(R.id.button)
    Button buttonLogin;
    @BindView(R.id.switchRememberMe)
    Switch switchRememberMe;
    @BindView(R.id.edtemail)
    EditText edtEmail;
    @BindView(R.id.edtpassword)
    EditText edtpassword;
    private DBUser mDBUser;

    private static final String TAG = "loginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDBUser = new DBUser(this);
        mUsersArrayList = mDBUser.getAllUsers();
        if ( mUsersArrayList.isEmpty()) {
            loadUserIntoDB();
        } else {
            for (User u : mUsersArrayList) {
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        convertListToMap();
        if (switchRememberMe.isChecked() == true) {
            getRememberMe();
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtpassword.getText().toString();
                if (edtEmail.getText().toString().isEmpty() || edtEmail.getText().toString().trim().length() == 0) {
                    edtEmail.setError("Enter valid email : ");
                    if (edtpassword.getText().toString().isEmpty() || edtpassword.getText().toString().trim().length() == 0) {
                        edtpassword.setError("Enter valid password: ");
                    }
                } else {
                    if (validateEmail(email)) {

                        String value = checkEmailVerification(email,password);
                        Log.e(TAG, "value: "+value );
                        if (value.equalsIgnoreCase("true")) {
                            Toast.makeText(loginActivity.this, "Correct Details Entered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(loginActivity.this, HomeActivity.class));

                            if (switchRememberMe.isChecked() == true) {
                                saveRememeberMe();
                            } else {
                                saveRememeberMeEmpty();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(),"Wrong credentials entered",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }


        });
    }

    private String checkEmailVerification(String email, String password) {
        for (int i =0 ; i<mUsersArrayList.size() ; i++) {
            if (mUsersArrayList.get(i).getEmail().equals(email)) {
                Log.e(TAG, "email found: " );
                if (mUsersArrayList.get(i).getPassword().equals(password)) {
                    Log.e(TAG, "password found: " );
                    return "True";
                }
            }
        }
        return "false";
    }


    private void saveRememeberMe() {
        mSharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        mEditor = mSharedpreferences.edit();
        mEditor.putString("email", edtEmail.getText().toString());
        mEditor.putString("password", edtpassword.getText().toString());
        mEditor.commit();
    }
    private void saveRememeberMeEmpty() {
        mSharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        mEditor = mSharedpreferences.edit();
        mEditor.putString("email", "");
        mEditor.putString("password", "");
        mEditor.commit();
    }
    private void getRememberMe() {
        mSharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        mEditor = mSharedpreferences.edit();
        String email = mSharedpreferences.getString("email", "");
        String password = mSharedpreferences.getString("password", "");
        edtEmail.setText(email);
        edtpassword.setText(password);
    }
    public Boolean validateEmail(String email) {
        String regex = "^[a-z0-9A-Z\\.]*@[a-z0-9A-Z]*\\.[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    public void loadUserIntoDB() {
        User user1 = new User(1, "karangmail.com", "karan123");
        mDBUser.insert(user1);
        User user2 = new User(2, "naina@gmail.com", "naina123");
        mDBUser.insert(user2);
        User user3 = new User(3, "jazz@gmail.com.com", "jazz123");
        mDBUser.insert(user3);
        User user4 = new User(4, "kishore@gmail.com", "kishore123");
        mDBUser.insert(user4);
        User user5 = new User(5, "shivani@gmail.com", "shivani123");
        mDBUser.insert(user5);
    }
    private void convertListToMap() {
        for (User u : mUsersArrayList) {
//            usersMapList.put(u.getEmail(), u.getPassword());
        }
    }
}
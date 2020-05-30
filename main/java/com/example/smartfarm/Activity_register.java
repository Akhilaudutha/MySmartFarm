package com.example.smartfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import android.os.Bundle;

public class Activity_register extends AppCompatActivity {
    private EditText username, inputEmail, phone, inputPassword;
    private Button btnSignUp;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        username = (EditText) findViewById(R.id.username);
        inputEmail = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        inputPassword = (EditText) findViewById(R.id.password);
        btnSignUp = (Button) findViewById(R.id.signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkDataEntered();

                startActivity(new Intent(Activity_register.this, MainActivity.class));

            }
        });

    }



    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(username)) {
            Toast t = Toast.makeText(this, "enter username", Toast.LENGTH_SHORT);
            t.show();
            username.setError("enter username");
        }


        if (!isEmail(inputEmail)) {
            inputEmail.setError("Enter valid email!");

        }
        if (isEmpty(phone)) {
            Toast t = Toast.makeText(this, "Phone number cant be empty", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(inputPassword)) {
            Toast t = Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT);
            t.show();
        }
    }





}

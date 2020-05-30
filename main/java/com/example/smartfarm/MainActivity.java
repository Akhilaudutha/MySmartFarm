package com.example.smartfarm;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView createTxt, recoverTxt;
    TextInputEditText emailEdt, passEdt;
    Button login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View createTxt = findViewById(R.id.createTxt);
        View recoverTxt = findViewById(R.id.recoverTxt);
        emailEdt = findViewById(R.id.emailEdt);
        passEdt = findViewById(R.id.passEdt);
        login = findViewById(R.id.loginBtn);
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEdt.getText().toString();
                String pass = passEdt.getText().toString();
                mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        createTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_register.class);
                startActivity(intent);
            }
        });

        recoverTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_resetpswd.class);
                startActivity(intent);
            }
        });
    }
}




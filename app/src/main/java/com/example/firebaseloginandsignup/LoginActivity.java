package com.example.firebaseloginandsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText memail, mpassword;
    private Button loginbtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        memail = findViewById(R.id.e3);
        mpassword = findViewById(R.id.e4);
        loginbtn = findViewById(R.id.btn2);
        mAuth = FirebaseAuth.getInstance();
    }

    public void signin(View view) {
        String email = memail.getText().toString();
        String Pass = mpassword.getText().toString();
        if (email.equals("")) {
            memail.setError("Email Required");
            if (Pass.equals("")) {
                mpassword.setError("password Required");
            }
        } else {
            mAuth.signInWithEmailAndPassword(email,Pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                         Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),"login Error",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
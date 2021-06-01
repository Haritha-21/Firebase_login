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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText memail,mpassword;
    private Button mbtn;
    private TextView mtextview;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memail=findViewById(R.id.e1);
        mpassword=findViewById(R.id.e2);
        mbtn=findViewById(R.id.btn1);
        mtextview=findViewById(R.id.tv1);


        mAuth=FirebaseAuth.getInstance();
    }

    public void signup(View view) {
        String email=memail.getText().toString();
        String Pass=mpassword.getText().toString();
       if (email.equals("")){
           memail.setError("Email Required");
           if (Pass.equals("")){
               mpassword.setError("password Required");
           }
       }else{
           //Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
           mAuth.createUserWithEmailAndPassword(email,Pass)
                   .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                           //Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                           //startActivity(intent);
                       }
                   }).addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception e) {
                   Toast.makeText(getApplicationContext(),"Registration Error",Toast.LENGTH_SHORT).show();
               }
           });
       }
    }

    public void login(View view) {
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
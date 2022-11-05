package com.example.learnenglishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hamKhaiBao();
        hamDieuKhien();
    }

    private void hamKhaiBao() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void hamDieuKhien() {
    }


    protected void onStart() {

        super.onStart();

        FirebaseUser currenUser = firebaseAuth.getCurrentUser();
        if(currenUser == null){
            startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            finish();
        }
    }
}
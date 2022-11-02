package com.example.learnenglishapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, com.example.learnenglishapp.LogInActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    /*private void nextActivity() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            Intent intent = new Intent(Splash.this, SignIn.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(Splash.this, MainActivity.class);
            startActivity(intent);
        }
        finish();
    }*/
}
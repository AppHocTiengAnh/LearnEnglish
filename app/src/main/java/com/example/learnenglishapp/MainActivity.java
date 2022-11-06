package com.example.learnenglishapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Toolbar mainToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        mainToolbar = findViewById(R.id.main_toolbar);
        getSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Learn English");
    }

    private void getSupportActionBar(Toolbar mainToolbar) {
    }

    protected void onStart() {

        super.onStart();

        FirebaseUser currenUser = firebaseAuth.getCurrentUser();
        if(currenUser == null){
            startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.profile_menu){
            
        } else {
            firebaseAuth.signOut();
            startActivity(new Intent(MainActivity.this , LogInActivity.class));
            finish();
        }

        return true;
    }
}
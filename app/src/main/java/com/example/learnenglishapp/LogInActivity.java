package com.example.learnenglishapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {
    TextView txtQuenMK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        hamKhaiBao();
        hamDieuKhien();
    }
    private void hamKhaiBao() {
        txtQuenMK = findViewById(R.id.txtQuenMK);
    }

    private void hamDieuKhien() {
        txtQuenMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quenMK = new Intent(LogInActivity.this, com.example.learnenglishapp.ForgotPasswordActivity.class);
                startActivity(quenMK);
            }
        });
    }
}
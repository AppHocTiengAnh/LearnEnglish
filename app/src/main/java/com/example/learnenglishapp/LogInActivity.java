package com.example.learnenglishapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private Button btnDangNhap;
    TextView txtQuenMK, txtDangKyTK;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        hamKhaiBao();
        hamDieuKhien();
    }

    private void hamKhaiBao() {
        txtQuenMK = findViewById(R.id.txtQuenMK);
        txtDangKyTK = findViewById(R.id.txtDangKyTK);
        mauth = FirebaseAuth.getInstance();
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        btnDangNhap = findViewById(R.id.btnDangNhap);
    }

    private void hamDieuKhien() {
        txtQuenMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quenMK = new Intent(LogInActivity.this, com.example.learnenglishapp.ResetPasswordActivity.class);
                startActivity(quenMK);
            }
        });
        txtDangKyTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DangKyTK = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(DangKyTK);
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                    String email = edtEmail.getText().toString();
                    String pass = edtPassword.getText().toString();

                    if(!email.isEmpty() && !pass.isEmpty()){
                        mauth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LogInActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LogInActivity.this, MainActivity.class));
                                    finish();
                                } else{
                                    Toast.makeText(LogInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(LogInActivity.this, "Please Enter Email, Password!!!", Toast.LENGTH_SHORT).show();
                    }
                }
        });

    }



}
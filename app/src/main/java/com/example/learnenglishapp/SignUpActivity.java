package com.example.learnenglishapp;

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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    TextView txtQuenMK, txtDangNhap;
    private EditText emailSignUp, passwordSignUp, passwordSignUpAgain;
    private Button btnSignUp;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        hamKhaiBao();
        hamDieuKhien();

    }

    private void hamKhaiBao() {
        txtQuenMK = findViewById(R.id.txtQuenMK);
        txtDangNhap = findViewById(R.id.txtDangNhap);
        btnSignUp = findViewById(R.id.btnSignUp);
        emailSignUp = findViewById(R.id.emailSignUp);
        passwordSignUp = findViewById(R.id.passwordSignUp);
        passwordSignUpAgain = findViewById(R.id.passwordSignUpAgain);
    }

    private void hamDieuKhien() {
        txtDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DangNhap = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(DangNhap);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailSignUp.getText().toString();
                String pass = passwordSignUp.getText().toString();
                String passagain = passwordSignUpAgain.getText().toString();

                if(!email.isEmpty() && !pass.isEmpty() && !passagain.isEmpty()){
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
                                finish();
                            } else{
                                Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this, "Vui lòng nhập đầy đủ thông tin!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}
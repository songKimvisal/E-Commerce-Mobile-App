package com.example.loginregisterapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnRegister, btnGoToLogin;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnGoToLogin = findViewById(R.id.btnGoToLogin);
        db = new DatabaseHelper(this);

        btnRegister.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim(); // Trim whitespace
            String password = etPassword.getText().toString().trim(); // Trim whitespace

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                return; // Exit if fields are empty
            }

            if (db.registerUser(username, password)) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Registration Failed. Username might be already taken.", Toast.LENGTH_SHORT).show(); // More specific message
            }
        });

        btnGoToLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish(); //Added finish to prevent back stack issues.
        });
    }
}
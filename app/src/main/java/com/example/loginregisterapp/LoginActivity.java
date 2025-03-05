package com.example.loginregisterapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etLoginUsername, etLoginPassword;
    private Button btnLogin, btnRegister;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        db = new DatabaseHelper(this);

        btnLogin.setOnClickListener(v -> {
            String username = etLoginUsername.getText().toString().trim(); // Trim whitespace
            String password = etLoginPassword.getText().toString().trim(); // Trim whitespace

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                return; // Exit the listener if fields are empty
            }

            if (db.checkUser(username, password)) {
                SharedPreferences sp = getSharedPreferences("UserSession", MODE_PRIVATE);
                sp.edit().putBoolean("isLoggedIn", true).apply();

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
            finish();
        });
    }
}
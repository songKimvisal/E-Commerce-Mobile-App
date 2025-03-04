package com.example.loginregisterapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginregisterapp.LoginActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnLogout = new Button(this);
        btnLogout.setText("Logout");
        setContentView(btnLogout);

        btnLogout.setOnClickListener(v -> {
            SharedPreferences sp = getSharedPreferences("UserSession", MODE_PRIVATE);
            sp.edit().clear().apply();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}

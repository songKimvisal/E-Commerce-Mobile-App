package com.example.loginregisterapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a LinearLayout to hold the button
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL); // Set orientation to vertical

        // Create the logout button
        Button btnLogout = new Button(this);
        btnLogout.setText("Logout");

        // Add the button to the layout
        layout.addView(btnLogout);

        // Set the layout as the content view
        setContentView(layout);

        btnLogout.setOnClickListener(v -> {
            SharedPreferences sp = getSharedPreferences("UserSession", MODE_PRIVATE);
            sp.edit().clear().apply();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class)); // Corrected LoginActivity class
            finish();
        });
    }
}
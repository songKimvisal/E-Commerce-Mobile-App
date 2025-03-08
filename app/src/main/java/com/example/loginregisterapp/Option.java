package com.example.loginregisterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Option extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable Edge-to-Edge before setting content view
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_option);

        // Apply insets to the view with ID "main"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set image resources for ImageViews
        ImageView imageView = findViewById(R.id.userBtn);
        imageView.setImageResource(R.drawable.user);

        ImageView imageView1= findViewById(R.id.adminBtn);
        imageView1.setImageResource(R.drawable.admin);
    }

    // Intent to LoginActivity when user button is clicked
    public void userOnclick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    // Intent to AdminRegistration (typo fixed) when admin button is clicked
    public void adminOnClick(View view) { // Fixed typo: "adnimOnclick" to "adminOnclick"
        Intent intent = new Intent(this, AdminResgisteration.class); // Also check this class name for typos
        startActivity(intent);
    }
}
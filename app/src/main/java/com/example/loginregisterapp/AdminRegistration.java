package com.example.loginregisterapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class AdminRegistration extends AppCompatActivity {
    private final int Admin_code = 1111;
    private Button adminBtn;
    private TextInputEditText adminCodeInput;
    private TextView errorMessage; // Added error message TextView

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_resgisteration);

        adminBtn = findViewById(R.id.adminBtn);
        adminCodeInput = findViewById(R.id.adminCodeInput);
        errorMessage = findViewById(R.id.errorMessage); // Initialize error message TextView

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = adminCodeInput.getText().toString();

                if (userInput.equals(String.valueOf(Admin_code))) {
                    Intent intent = new Intent(AdminRegistration.this, MainActivity.class); // Replace with your next activity
                    startActivity(intent);
                    finish();
                } else {
                    errorMessage.setText("Incorrect Admin Code. Please try again."); // Set error message
                    adminCodeInput.getText().clear();
                }
            }
        });
    }
}
package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to the RecyclerView
        RecyclerView horizontalRecyclerView = findViewById(R.id.horizontalRecyclerView);

        // Create a list of image resource IDs
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.image1); // Replace with your actual image resources
        imageList.add(R.drawable.image2);
//        imageList.add(R.drawable.image3);
        // ... add more images

        // Create the adapter
        HorizontalImageAdapter adapter = new HorizontalImageAdapter(imageList);

        // Set the adapter and layout manager for the RecyclerView
        horizontalRecyclerView.setAdapter(adapter);
        horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}
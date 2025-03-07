package com.example.loginregisterapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // List of colors (mimicking your current ImageViews)
        List<Integer> colors = Arrays.asList(
                android.R.color.holo_blue_light,  // item1
                android.R.color.holo_green_light, // item2
                android.R.color.holo_red_light,   // item3
                android.R.color.holo_purple,      // item4
                android.R.color.holo_red_light    // item5
        );

        // Set the adapter
        ImageAdapter adapter = new ImageAdapter(colors);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
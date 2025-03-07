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

public class ShopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.shopRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Example data (replace with real shop items)
        List<Integer> colors = Arrays.asList(
                android.R.color.holo_blue_light,
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_green_light,
                android.R.color.holo_blue_light,
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_green_light,
                android.R.color.holo_green_light,
                android.R.color.holo_red_light,
                android.R.color.holo_red_light
        );
        ImageAdapter adapter = new ImageAdapter(colors);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
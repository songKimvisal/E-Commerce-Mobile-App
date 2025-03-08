package com.example.loginregisterapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ProfileFragment extends Fragment {

    private RecyclerView profileRecyclerView;
    private Button switchAccountButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileRecyclerView = view.findViewById(R.id.profileRecyclerView); // Initialize profileRecyclerView
        switchAccountButton = view.findViewById(R.id.switchAccountButton); // Initialize switchAccountButton

        profileRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Integer> colors = Arrays.asList(
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_red_light
        );
        ImageAdapter adapter = new ImageAdapter(colors);
        profileRecyclerView.setAdapter(adapter);

        switchAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAccountType(getContext()); // Use getContext() for fragment context

                Intent intent = new Intent(getContext(), Option.class); // Use getContext() for fragment context
                startActivity(intent);
                if (getActivity() != null) {
                    getActivity().finish(); // Close the activity hosting the fragment
                }
            }
        });

        return view;
    }

    private void clearAccountType(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("account_prefs", Context.MODE_PRIVATE);
        prefs.edit().remove("account_type").apply();
    }
}
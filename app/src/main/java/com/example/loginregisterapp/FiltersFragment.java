package com.example.loginregisterapp;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FiltersFragment extends Fragment {

    private static final String TAG = "FiltersFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: FiltersFragment loaded");
        View view = inflater.inflate(R.layout.fragment_filters, container, false);

        Button filtersListButton = view.findViewById(R.id.filtersListButton);
        Button selectSizeButton = view.findViewById(R.id.selectSizeButton);

        if (filtersListButton == null || selectSizeButton == null) {
            Log.e(TAG, "Buttons are null. Check fragment_filters.xml for correct IDs");
            return view;
        }

        filtersListButton.setOnClickListener(v -> {
            Log.d(TAG, "Navigating to FiltersListFragment");
            try {
                if (getChildFragmentManager() != null) {
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.filters_container, new FiltersListFragment())
                            .addToBackStack(null)
                            .commit();
                } else {
                    Log.e(TAG, "ChildFragmentManager is null");
                }
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "Fragment transaction failed: " + e.getMessage());
            }
        });

        selectSizeButton.setOnClickListener(v -> {
            Log.d(TAG, "Navigating to SelectSizeFragment");
            try {
                if (getChildFragmentManager() != null) {
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.filters_container, new SelectSizeFragment())
                            .addToBackStack(null)
                            .commit();
                } else {
                    Log.e(TAG, "ChildFragmentManager is null");
                }
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "Fragment transaction failed: " + e.getMessage());
            }
        });

        return view;
    }
}
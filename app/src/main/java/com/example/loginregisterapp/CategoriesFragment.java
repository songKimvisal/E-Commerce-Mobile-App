package com.example.loginregisterapp;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesFragment extends Fragment {

    private static final String TAG = "CategoriesFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: CategoriesFragment loaded");
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.categoriesRecyclerView);
        if (recyclerView == null) {
            Log.e(TAG, "RecyclerView is null");
            return view;
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] categories = {"Women", "Men", "Kids"};
        CategoriesAdapter adapter = new CategoriesAdapter(categories);
        recyclerView.setAdapter(adapter);

        Log.d(TAG, "RecyclerView set with " + categories.length + " categories");
        return view;
    }
}
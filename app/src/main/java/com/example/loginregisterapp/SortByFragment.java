package com.example.loginregisterapp;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SortByFragment extends Fragment {

    private static final String TAG = "SortByFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: SortByFragment loaded");
        View view = inflater.inflate(R.layout.fragment_sort_by, container, false);

        ListView listView = view.findViewById(R.id.sortListView);
        if (listView == null) {
            Log.e(TAG, "ListView is null");
            return view;
        }

        String[] sortOptions = {"Popular", "Price: High to Low", "Price: Low to High", "Newest"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, sortOptions);
        listView.setAdapter(adapter);

        Log.d(TAG, "ListView set with " + sortOptions.length + " sort options");
        return view;
    }
}
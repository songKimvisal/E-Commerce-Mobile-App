package com.example.loginregisterapp;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FiltersListFragment extends Fragment {

    private static final String TAG = "FiltersListFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: FiltersListFragment loaded");
        View view = inflater.inflate(R.layout.fragment_filters_list, container, false);

        ListView listView = view.findViewById(R.id.filtersListView);
        if (listView == null) {
            Log.e(TAG, "ListView is null");
            return view;
        }

        String[] filterOptions = {"Adidas Originals", "Blend Boutique", "Champion", "Diesel", "Jack & Jones", "Red Valentino", "Scotch & Soda"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_multiple_choice, filterOptions);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        Log.d(TAG, "ListView set with " + filterOptions.length + " filter options");
        return view;
    }
}
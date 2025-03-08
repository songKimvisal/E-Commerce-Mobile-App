package com.example.loginregisterapp;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

public class SelectSizeFragment extends Fragment {

    private static final String TAG = "SelectSizeFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: SelectSizeFragment loaded");
        View view = inflater.inflate(R.layout.fragment_select_size, container, false);

        RadioGroup radioGroup = view.findViewById(R.id.sizeRadioGroup);
        Button applyButton = view.findViewById(R.id.applyButton);

        if (radioGroup == null || applyButton == null) {
            Log.e(TAG, "RadioGroup or ApplyButton is null");
            return view;
        }

        applyButton.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            Log.d(TAG, "Size selected, navigating back");
            getParentFragmentManager().popBackStack();
        });

        return view;
    }
}
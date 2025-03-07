package com.example.loginregisterapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Sample data
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("-20%", android.R.drawable.ic_menu_gallery, 5.0f, 10, "Dorothy Perkins Evening Dress", "£25 £125"));
        productList.add(new Product("-15%", android.R.drawable.ic_menu_gallery, 5.0f, 10, "Stylish Sporty Dress", "£22 £19"));
        productList.add(new Product("-2%", android.R.drawable.ic_menu_gallery, 5.0f, 10, "Dorothy Perkins Sporty", "£145"));

        // Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new ProductAdapter(productList));

        return view;
    }
}
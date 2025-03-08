package com.example.loginregisterapp;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CatalogFragment extends Fragment {

    private static final String TAG = "CatalogFragment";
    private ShopDatabaseHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: CatalogFragment loaded");
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.catalogRecyclerView);
        if (recyclerView == null) {
            Log.e(TAG, "RecyclerView is null");
            return view;
        }

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        dbHelper = new ShopDatabaseHelper(requireContext());
        List<Product> products = dbHelper.getAllProducts();
        if (products.isEmpty()) {
            Log.w(TAG, "No products found in database");
        } else {
            Log.d(TAG, "Loaded " + products.size() + " products");
        }

        ProductAdapter adapter = new ProductAdapter(products);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}
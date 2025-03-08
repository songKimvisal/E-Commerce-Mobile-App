package com.example.loginregisterapp;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ShopFragment extends Fragment {

    private static final String TAG = "ShopFragment";
    private ViewPager2 viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ShopFragment loaded");
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);

        if (viewPager == null || tabLayout == null) {
            Log.e(TAG, "ViewPager or TabLayout is null");
            return view;
        }

        ShopPagerAdapter pagerAdapter = new ShopPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        Log.d(TAG, "ViewPager adapter set with item count: " + pagerAdapter.getItemCount());

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Categories");
                    break;
                case 1:
                    tab.setText("Catalog");
                    break;
                case 2:
                    tab.setText("Sort by");
                    break;
                case 3:
                    tab.setText("Filters");
                    break;
            }
        }).attach();

        return view;
    }
}

class ShopPagerAdapter extends FragmentStateAdapter {
    private static final String TAG = "ShopPagerAdapter";

    public ShopPagerAdapter(Fragment fragment) {
        super(fragment);
    }

    @Override
    public Fragment createFragment(int position) {
        Log.d(TAG, "Creating fragment at position: " + position);
        switch (position) {
            case 0:
                return new CategoriesFragment();
            case 1:
                return new CatalogFragment();
            case 2:
                return new SortByFragment();
            case 3:
                return new FiltersFragment();
            default:
                return new CategoriesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
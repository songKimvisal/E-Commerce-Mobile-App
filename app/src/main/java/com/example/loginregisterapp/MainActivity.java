package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Fragment homeFragment;
    private Fragment shopFragment;
    private Fragment cartFragment;
    private Fragment favoriteFragment;
    private Fragment profileFragment;

    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        homeFragment = new HomeFragment();
        shopFragment = new ShopFragment();
        cartFragment = new CartFragment();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, homeFragment, "HomeFragment")
                    .commit();
            activeFragment = homeFragment;

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, shopFragment, "ShopFragment")
                    .hide(shopFragment)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, cartFragment, "CartFragment")
                    .hide(cartFragment)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, favoriteFragment, "FavoriteFragment")
                    .hide(favoriteFragment)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, profileFragment, "ProfileFragment")
                    .hide(profileFragment)
                    .commit();
        } else {
            homeFragment = getSupportFragmentManager().findFragmentByTag("HomeFragment");
            shopFragment = getSupportFragmentManager().findFragmentByTag("ShopFragment");
            cartFragment = getSupportFragmentManager().findFragmentByTag("CartFragment");
            favoriteFragment = getSupportFragmentManager().findFragmentByTag("FavoriteFragment");
            profileFragment = getSupportFragmentManager().findFragmentByTag("ProfileFragment");

            // Determine the active fragment (e.g., assume Home if not restored properly)
            String activeTag = Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.fragment_container)).getTag();
            activeFragment = getSupportFragmentManager().findFragmentByTag(activeTag != null ? activeTag : "HomeFragment");
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                selectedFragment = homeFragment;
            } else if (itemId == R.id.nav_shop) {
                selectedFragment = shopFragment;
            } else if (itemId == R.id.nav_cart) {
                selectedFragment = cartFragment;
            } else if (itemId == R.id.nav_favorite) {
                selectedFragment = favoriteFragment;
            } else if (itemId == R.id.nav_profile) {
                selectedFragment = profileFragment;
            }

            if (selectedFragment != null && selectedFragment != activeFragment) {
                getSupportFragmentManager().beginTransaction()
                        .hide(activeFragment)
                        .show(selectedFragment)
                        .commit();
                activeFragment = selectedFragment;
            }
            return true;
        });

        bottomNavigationView.setSelectedItemId(R.id.nav_home);


    }
}
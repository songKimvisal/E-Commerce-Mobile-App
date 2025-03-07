package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // Keep references to fragments to avoid recreating them
    private Fragment homeFragment;
    private Fragment shopFragment;
    private Fragment cartFragment;
    private Fragment favoriteFragment;
    private Fragment profileFragment;

    private Fragment activeFragment; // Track the currently active fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Initialize fragments
        homeFragment = new HomeFragment();
        shopFragment = new ShopFragment();
        cartFragment = new CartFragment();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();

        // Set up the default fragment (Home)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, homeFragment, "HomeFragment")
                    .commit();
            activeFragment = homeFragment;

            // Add other fragments but hide them
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
            // Restore fragments after configuration change
            homeFragment = getSupportFragmentManager().findFragmentByTag("HomeFragment");
            shopFragment = getSupportFragmentManager().findFragmentByTag("ShopFragment");
            cartFragment = getSupportFragmentManager().findFragmentByTag("CartFragment");
            favoriteFragment = getSupportFragmentManager().findFragmentByTag("FavoriteFragment");
            profileFragment = getSupportFragmentManager().findFragmentByTag("ProfileFragment");

            // Restore the active fragment
            activeFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        }

        // Handle navigation item selection using the non-deprecated method
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

        // Set the default selected item in BottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

    }
}
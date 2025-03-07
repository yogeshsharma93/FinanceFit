package com.example.financefit;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FrameLayout extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    android.widget.FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        frameLayout = findViewById(R.id.frameLayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.navHome)
                {
                    loadFragment(new HomeFragment(), false);

                } else if (itemId == R.id.navBudget) {
                    loadFragment(new BudgetFragment(), false);

                } else if (itemId == R.id.navExpenses) {
                    loadFragment(new ExpenseFragment(), false);
                } else if (itemId == R.id.navAnalytics) {
                    loadFragment(new AnalyticsFragment(), false);
                }
                else {
                    loadFragment(new ProfileFragment(), false);
                }
                return true;
            }
        });
        loadFragment(new HomeFragment(), true);

    }
    void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized){
            fragmentTransaction.add(R.id.frameLayout, fragment);
        }
        else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }
        fragmentTransaction.commit();
    }
}
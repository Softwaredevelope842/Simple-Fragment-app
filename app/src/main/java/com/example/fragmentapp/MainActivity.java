package com.example.fragmentapp;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        frameLayout=(FrameLayout) findViewById(R.id.framelayout);
        tabLayout=(TabLayout) findViewById(R.id.tablayout);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new FirstFragment())
                .addToBackStack(null)
                .commit();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              Fragment fragment =null;
              switch (tab.getPosition()){
                  case 0:
                      fragment = new FirstFragment();
                      break;
                  case 1:
                      fragment = new SecondFragment();
                      break;
                  case 2:
                      fragment = new ThirdFragment();
                      break;

              }
              getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment)
                      .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                      .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
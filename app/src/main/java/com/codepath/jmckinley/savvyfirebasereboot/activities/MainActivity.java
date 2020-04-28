package com.codepath.jmckinley.savvyfirebasereboot.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.codepath.jmckinley.savvyfirebasereboot.fragments.CallFragment;
import com.codepath.jmckinley.savvyfirebasereboot.fragments.PreferenceFragment;
import com.codepath.jmckinley.savvyfirebasereboot.fragments.SwipeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            Fragment fragment;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_call:
                        // Load CallFragment
                        fragment = new CallFragment();
                        break;
                    case R.id.action_message:
                        // Load MessageFragment
//                        fragment = new MessageFragment();
                        break;
                    case R.id.action_main:
                        // Load SwipeFragment
                        fragment = new SwipeFragment();
                        break;
                    case R.id.action_settings:
                        // Load PreferenceFragment
                        fragment = new PreferenceFragment();
                        break;
                    default:
                        // load SwipeFragment by default
                        fragment = new SwipeFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        // Set default selection on bottom navi.
        bottomNavigationView.setSelectedItemId(R.id.action_main);

    }


















}

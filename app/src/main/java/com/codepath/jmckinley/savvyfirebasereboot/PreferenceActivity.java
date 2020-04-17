package com.codepath.jmckinley.savvyfirebasereboot;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PreferenceActivity  extends AppCompatActivity {

    public static final String TAG = "PreferenceActivity";

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_call:
                        goToCallActivity();
                        break;
                    case R.id.action_message:
                        goToMessageActivity();
                        break;
                    case R.id.action_main:
                        goToMainActivity();
                        break;
                    case R.id.action_settings:
//                        goToPreferenceActivity();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_settings);
    }

    private void goToEditProfile() {
        Intent i = new Intent(this, EditProfileActivity.class);
        startActivity(i);
    }

    private void goToLogin() {
        Intent i = new Intent(this, SignInActivity.class);
        startActivity(i);
    }

    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity_.class);
        startActivity(i);
    }

    private void goToPreferenceActivity() {
        Intent i = new Intent(this, PreferenceActivity.class);
        startActivity(i);
    }

    private void goToMessageActivity() {
        Intent i = new Intent(this, MessageActivity.class);
        startActivity(i);
    }

    private void goToCallActivity() {
        Intent i = new Intent(this, CallActivity.class);
        startActivity(i);
    }
}

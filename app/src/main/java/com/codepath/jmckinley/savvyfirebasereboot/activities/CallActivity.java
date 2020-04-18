package com.codepath.jmckinley.savvyfirebasereboot.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CallActivity extends AppCompatActivity {

    public static final String TAG = "CallActivity";

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_call:
//                        goToCallActivity();
                        break;
                    case R.id.action_message:
                        goToMessageActivity();
                        break;
                    case R.id.action_main:
                        goToMainActivity();
                        break;
                    case R.id.action_settings:
                        goToPreferenceActivity();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_call);
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

package com.codepath.jmckinley.savvyfirebasereboot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            Fragment fragment;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_call:
                        // do something here
                        break;
                    case R.id.action_message:
                        // do something here
                        break;
                    case R.id.action_main:
                        // do something here
                        break;
                    case R.id.action_settings:
                        // do something here
                        break;
                    default:
                        // do something here
                        break;
                }
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_main);

    }


    private void goToPreferenceActivity() {
        Log.i(TAG, "Attempting to return to loginActivity");
        // use intent system to navigate to new activity
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();

    }

    private void goToMainActivity() {
        Log.i(TAG, "Attempting to return to loginActivity");
        // use intent system to navigate to new activity
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();

    }

    private void goToMessageActivity() {
        Log.i(TAG, "Attempting to return to loginActivity");
        // use intent system to navigate to new activity
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();

    }

    private void goToCallActivity() {
        Log.i(TAG, "Attempting to return to loginActivity");
        // use intent system to navigate to new activity
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();

    }
















}

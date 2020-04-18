package com.codepath.jmckinley.savvyfirebasereboot.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.codepath.jmckinley.savvyfirebasereboot.activities.EditProfileActivity;
import com.codepath.jmckinley.savvyfirebasereboot.activities.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreferenceFragment extends PreferenceFragmentCompat {


    // declare preference items
    Preference logout;


    private static final String TAG = "PreferenceFragment";

    private FirebaseAuth mAuth;

    public PreferenceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Inflate XML preference file
        setPreferencesFromResource(R.xml.preferences, rootKey);

        // link preference key to the fragment
        logout = findPreference("logout");

        // set preference onClickListener
        logout.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "You are now logged out", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                goToLogin();
                return false;
            }
        });

    }

    // navigate to login activity
    private void goToLogin() {
        Intent i = new Intent(getActivity(), SignInActivity.class);
        startActivity(i);
    }

}





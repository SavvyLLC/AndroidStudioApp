package com.codepath.jmckinley.savvyfirebasereboot.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceFragmentCompat;

import com.codepath.jmckinley.savvyfirebasereboot.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreferenceFragment extends PreferenceFragmentCompat {


    public PreferenceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Inflate XML preference file
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

}

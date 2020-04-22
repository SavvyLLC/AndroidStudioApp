package com.codepath.jmckinley.savvyfirebasereboot.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.codepath.jmckinley.savvyfirebasereboot.activities.CallActivity;
import com.codepath.jmckinley.savvyfirebasereboot.activities.DetailedUserSelection;
import com.codepath.jmckinley.savvyfirebasereboot.activities.EditProfileActivity;
//import com.codepath.jmckinley.savvyfirebasereboot.activities.Obsolete_MainActivity;
import com.codepath.jmckinley.savvyfirebasereboot.activities.MainActivity;
import com.codepath.jmckinley.savvyfirebasereboot.activities.MessageActivity;
import com.codepath.jmckinley.savvyfirebasereboot.activities.PreferenceActivity;
import com.codepath.jmckinley.savvyfirebasereboot.activities.SignInActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwipeFragment extends Fragment {

    public static final String TAG = "SwipeFragment";

    private FirebaseFirestore fStore;
    private FirebaseAuth mAuth;

    private BottomNavigationView bottomNavigationView;

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;


    public SwipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_swipe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //FlingContainer - Begin

        al = new ArrayList<>();
        al.add("php");
        al.add("c");
        al.add("python");
        al.add("java");
        al.add("html");
        al.add("c++");
        al.add("css");
        al.add("javascript");

        arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.item, R.id.helloText, al);

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) getActivity().findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener(){


            @Override
            public void removeFirstObjectInAdapter() {
                //simplest way to delete an object from the adapater
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();;
            }

            @Override
            /*
            Disgard a user
             */
            public void onLeftCardExit(Object dataObject){
                //Do something on the left!
                Toast.makeText(getActivity(), "Left!", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Swipe Left");
            }

            @Override
            public void onRightCardExit(Object dataObject){
//                Toast.makeText(MainActivity.this, "Right!", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Swipe Right");
            }

            /*
            Detects that adapater is about to empty so fill it in with more information
             */
            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapater){
                al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("List", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent){
                Toast.makeText(getActivity(), "click!", Toast.LENGTH_LONG).show();
                Log.d(TAG, "click!");

                //TODO Find a better solution to more accurate click detector
                //Quick fix to detect click
                if(scrollProgressPercent == 0){
                    goToDetailedUserSelection();
                }
            }
        });

        //fStore = FirebaseFirestore.getInstance();   // Initialize Firestore
        mAuth = FirebaseAuth.getInstance();         // Initialize Firebase Auth
    }

    private void goToDetailedUserSelection() {
        Intent i = new Intent(getActivity(), DetailedUserSelection.class);
        startActivity(i);
    }

//    private void goToEditProfile() {
//        Intent i = new Intent(getActivity(), EditProfileActivity.class);
//        startActivity(i);
//    }
//
//    private void goToLogin() {
//        Intent i = new Intent(getActivity(), SignInActivity.class);
//        startActivity(i);
//    }
//
//    private void goToMainActivity() {
//        Intent i = new Intent(getActivity(), MainActivity.class);
//        startActivity(i);
//    }
//
//    private void goToPreferenceActivity() {
//        Intent i = new Intent(getActivity(), PreferenceActivity.class);
//        startActivity(i);
//    }
//
//    private void goToMessageActivity() {
//        Intent i = new Intent(getActivity(), MessageActivity.class);
//        startActivity(i);
//    }
//
//    private void goToCallActivity() {
//        Intent i = new Intent(getActivity(), CallActivity.class);
//        startActivity(i);
//    }



}

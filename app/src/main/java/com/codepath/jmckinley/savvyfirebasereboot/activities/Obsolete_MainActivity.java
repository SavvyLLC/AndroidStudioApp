//package com.codepath.jmckinley.savvyfirebasereboot.activities;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.codepath.jmckinley.savvyfirebasereboot.R;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.lorentzos.flingswipe.SwipeFlingAdapterView;
//
//import java.util.ArrayList;
//
//public class Obsolete_MainActivity extends AppCompatActivity {
//
//    public static final String TAG = "MainActivity_";
//
//    private FirebaseFirestore fStore;
//    private FirebaseAuth mAuth;
//
//    private Button btnEditProfile;
//    private Button btnSignout;
//
//    private BottomNavigationView bottomNavigationView;
//
//    private ArrayList<String> al;
//    private ArrayAdapter<String> arrayAdapter;
//    private int i;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_);
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.action_call:
//                        goToCallActivity();
//                        break;
//                    case R.id.action_message:
//                        goToMessageActivity();
//                        break;
//                    case R.id.action_main:
////                        goToMainActivity();
//                        break;
//                    case R.id.action_settings:
//                        goToPreferenceActivity();
//                        break;
//                    default:
//                        break;
//                }
//                return true;
//            }
//        });
//        // Set default selection
//        bottomNavigationView.setSelectedItemId(R.id.action_main);
//
//
//
//
//
//
//
//        //FlingContainer - Begin
//
//        al = new ArrayList<>();
//        al.add("php");
//        al.add("c");
//        al.add("python");
//        al.add("java");
//        al.add("html");
//        al.add("c++");
//        al.add("css");
//        al.add("javascript");
//
//        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al);
//
//        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
//
//        flingContainer.setAdapter(arrayAdapter);
//        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener(){
//
//
//            @Override
//            public void removeFirstObjectInAdapter() {
//                //simplest way to delete an object from the adapater
//                Log.d("LIST", "removed object!");
//                al.remove(0);
//                arrayAdapter.notifyDataSetChanged();;
//            }
//
//            @Override
//            /*
//            Disgard a user
//             */
//            public void onLeftCardExit(Object dataObject){
//                //Do something on the left!
//                Toast.makeText(Obsolete_MainActivity.this, "Left!", Toast.LENGTH_LONG);
//                Log.d(TAG, "Swipe Left");
//            }
//
//            @Override
//            public void onRightCardExit(Object dataObject){
//                Toast.makeText(Obsolete_MainActivity.this, "Right!", Toast.LENGTH_LONG);
//                Log.d(TAG, "Swipe Right");
//            }
//
//            /*
//            Detects that adapater is about to empty so fill it in with more information
//             */
//            @Override
//            public void onAdapterAboutToEmpty(int itemsInAdapater){
//                al.add("XML ".concat(String.valueOf(i)));
//                arrayAdapter.notifyDataSetChanged();
//                Log.d("List", "notified");
//                i++;
//            }
//
//            @Override
//            public void onScroll(float scrollProgressPercent){
//                Toast.makeText(Obsolete_MainActivity.this, "click!", Toast.LENGTH_LONG);
//                Log.d(TAG, "click!");
//
//                //TODO Find a better solution to more accurate click detector
//                //Quick fix to detect click
//                if(scrollProgressPercent == 0){
//                    goToDetailedUserSelection();
//                }
//            }
//        });
//
//        //fStore = FirebaseFirestore.getInstance();   // Initialize Firestore
//        mAuth = FirebaseAuth.getInstance();         // Initialize Firebase Auth
//
//        btnEditProfile = findViewById(R.id.btnEditProfile);
//        btnSignout = findViewById(R.id.btnSignOut);
//
//        // Action: Navigate to EditProfileActivity
//        btnEditProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "Navigating to edit profile");
//                Toast.makeText(Obsolete_MainActivity.this, "Navigating to edit profile", Toast.LENGTH_SHORT).show();
//                goToEditProfile();
//
//            }
//        });
//
//        // Action: Sign out current user
//        btnSignout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "User signing out");
//                Toast.makeText(Obsolete_MainActivity.this, "You are now logged out", Toast.LENGTH_SHORT).show();
//                FirebaseAuth.getInstance().signOut();
//                goToLogin();
//            }
//        });
//    }
//
//    private void goToDetailedUserSelection() {
//        Intent i = new Intent(this, DetailedUserSelection.class);
//        startActivity(i);
//    }
//
//    private void goToEditProfile() {
//        Intent i = new Intent(this, EditProfileActivity.class);
//        startActivity(i);
//    }
//
//    private void goToLogin() {
//        Intent i = new Intent(this, SignInActivity.class);
//        startActivity(i);
//    }
//
//    private void goToMainActivity() {
//        Intent i = new Intent(this, Obsolete_MainActivity.class);
//        startActivity(i);
//    }
//
//    private void goToPreferenceActivity() {
//        Intent i = new Intent(this, PreferenceActivity.class);
//        startActivity(i);
//    }
//
//    private void goToMessageActivity() {
//        Intent i = new Intent(this, MessageActivity.class);
//        startActivity(i);
//    }
//
//    private void goToCallActivity() {
//        Intent i = new Intent(this, CallActivity.class);
//        startActivity(i);
//    }
//
//
//}

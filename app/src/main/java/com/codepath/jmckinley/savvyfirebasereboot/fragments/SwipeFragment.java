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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * A simple {@link Fragment} subclass.
 * Checks to see if anyone has matched with the current entity
 */

interface OnFoundMatchCallBack{
    public void onFoundMatchingEntity(boolean bool);
}
public class SwipeFragment extends Fragment {

    public static final String TAG = "SwipeFragment";

    private FirebaseFirestore fStore;
    private FirebaseAuth mAuth;

    private BottomNavigationView bottomNavigationView;

    private ArrayList<String> al;
    private ArrayList<String> originalAl;

    //Keeps track of all the account maps we've recevied. Conencts the name to a value
    //Not good for people with same name
    private HashMap<String, String> accountLogMap;
    private ArrayAdapter<String> arrayAdapter;
    private int i;

    HashMap<String, Boolean> originaFirebaseMatches;

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
        
        final FirebaseFirestore fStore =  FirebaseFirestore.getInstance();
        final FirebaseAuth mAuth;
        originaFirebaseMatches =  new HashMap<String, Boolean>();

        mAuth = FirebaseAuth.getInstance();         // Initialize Firebase Auth

        // usersList.addAll(do);
        al = new ArrayList();
        originalAl = new ArrayList<>();
        accountLogMap = new HashMap<String, String>();

        //TODO Put Student's view into it's own creation method
        //Filter users for accounts of type compnay
        ArrayList usersList = new ArrayList<>();
        fStore.collection("users")
                .whereEqualTo("isCompany", false)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                String fName = document.get("firstName").toString();
                                String lName = document.get("lastName").toString();

                                al.add(fName +" "+ lName);
                                originalAl.add(fName + " " +lName);

                                accountLogMap.put(fName + " " +lName, document.getId());

//                                for (Map.Entry<String, Object> entry : document.getData().entrySet()) {
//                                    String k = entry.getKey();
//                                    Object v = entry.getValue();
//                                    Log.d(TAG, "Key: " + k + ", Value: " + v);
//                                }
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });



        al.add("WELCOME TO SAVVY! Get to Swiping!");

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

                Log.d(TAG, "SKIP");

                //Do something on the left!
                Toast.makeText(getActivity(), "SKIP!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRightCardExit(final Object dataObject){
//                Toast.makeText(MainActivity.this, "Right!", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Swipe Right");

                if(dataObject.equals("WELCOME TO SAVVY! Get to Swiping!")) return;


                //Do something on the left!
                Toast.makeText(getActivity(), "Left!", Toast.LENGTH_LONG).show();

                fStore.collection("users").document("testStudentForSwiping2").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                originaFirebaseMatches = ((HashMap)(document.get("matches")));

                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                    }
                });

                Log.d(TAG,":DataObject Value: " + dataObject.toString());

                boolean matchFound = false;

                originaFirebaseMatches.put(accountLogMap.get(dataObject.toString()), matchFound);

                //TODO Do check to see if the user has any matches
                //Go to this saved user
                //See if they have the key value, if they do, there's a match, if not no

                //FUTURE: You can query the HashMap to see who the user actually has matches with O(n)
                fStore.collection("users").document("testStudentForSwiping2").update("matches", originaFirebaseMatches);
            }

            /*
            Check to see if anyone has matched to the current user
             */
//            public boolean checkToSeeIfEntityMatchedWithMe(final OnFoundMatchCallBack callBack, final Object dataObject){
//
//
//                fStore.collection("users")
//                        .whereEqualTo("isCompany", false)
//                        .get()
//                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                            @Override
//                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                if (task.isSuccessful()) {
//                                    for (QueryDocumentSnapshot document : task.getResult()) {
//                                        Log.d(TAG, document.getId() + " => " + document.getData());
//                                        Map<String, Boolean> matches = (HashMap)document.get("matches");
//
//                                        if(matches == null) {
//                                            Log.d(TAG, "Matches was null!");
//                                            callBack.onFoundMatchingEntity(false);
//                                            continue;
//                                        }
//
//                                        if(matches.containsKey(dataObject.toString())){
//                                            callBack.onFoundMatchingEntity(true);
//                                            //Update document
//                                            matches.put(dataObject.toString(), true);
//                                            fStore.collection("users").document(document.getId()).update("matches", matches);
//                                    }
//                                        callBack.onFoundMatchingEntity(false);
//                                    }
//                                    } else {
//                                        Log.d(TAG, "Error getting documents: ", task.getException());
//                                    }
//                                }
//                        });
//
//
//                //No match was found return false
//                return false;
//            }

            /*
            Detects that adapater is about to empty so fill it in with more information
             */
            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapater){
                //Quick fix on constantly displaying users from query to be added to back of list
                al.addAll(originalAl);
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
                    //goToDetailedUserSelection();
                }
            }
        });

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

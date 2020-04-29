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
import android.widget.ListView;
import android.widget.Toast;

import com.codepath.jmckinley.savvyfirebasereboot.Models.Cards;
import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.codepath.jmckinley.savvyfirebasereboot.activities.DetailedUserSelection;
//import com.codepath.jmckinley.savvyfirebasereboot.activities.Obsolete_MainActivity;
import com.codepath.jmckinley.savvyfirebasereboot.activities.MainActivity;
import com.codepath.jmckinley.savvyfirebasereboot.adapters.arrayAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Checks to see if anyone has matched with the current entity
 */


public class SwipeFragment extends Fragment {

    public static final String TAG = "SwipeFragment";

    private FirebaseFirestore fStore;
    private FirebaseAuth mAuth;

    private BottomNavigationView bottomNavigationView;

    private Cards cards_data[];
    private arrayAdapter arrayAdpt;


    //private ArrayList<String> originalAl;

    //Keeps track of all the account maps we've recevied. Conencts the name to a value
    //Not good for people with same name
    private HashMap<String, String> accountLogMap;
    private int i;

    HashMap<String, Boolean> originaFirebaseMatches;

    public SwipeFragment() {
        // Required empty public constructor
    }

    ListView listView;
    List<Cards> rowItems;
    List<Cards> rowItemsCopy;


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
        rowItems = new ArrayList<Cards>();
        rowItemsCopy = new ArrayList<Cards>();

        //originalAl = new ArrayList<>();
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

                                Cards item = new Cards(document.getId().toString(), fName +" "+ lName, document.get("profileImage").toString());
                                rowItems.add(item);
                                rowItemsCopy.add(item);
//                                al.add(fName +" "+ lName);
//                                originalAl.add(fName + " " +lName);

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



        //al.add("WELCOME TO SAVVY! Get to Swiping!");

        //For intial load of swipeable cards
      rowItems.add(new Cards("TEMPID", "Welcome to Savvy!", "https://1.bp.blogspot.com/-a9CVxC_p9Eo/Tmb0drWS21I/AAAAAAAAADI/ysbks8dJqUk/s1600/mickey_mouse.jpg"));

        //Picasso Array Adapter

        String[] eatFoodyImages = {
                "http://i.imgur.com/rFLNqWI.jpg",
                "http://i.imgur.com/C9pBVt7.jpg",
                "http://i.imgur.com/rT5vXE1.jpg",
                "http://i.imgur.com/aIy5R2k.jpg",
                "http://i.imgur.com/MoJs9pT.jpg",
                "http://i.imgur.com/S963yEM.jpg",
                "http://i.imgur.com/rLR2cyc.jpg",
                "http://i.imgur.com/SEPdUIx.jpg",
                "http://i.imgur.com/aC9OjaM.jpg",
                "http://i.imgur.com/76Jfv9b.jpg",
                "http://i.imgur.com/fUX7EIB.jpg",
                "http://i.imgur.com/syELajx.jpg",
                "http://i.imgur.com/COzBnru.jpg",
                "http://i.imgur.com/Z3QjilA.jpg",
        };




        //Picasso Array Adapter
        arrayAdpt = new arrayAdapter(getActivity(), R.layout.item, rowItems);

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) getActivity().findViewById(R.id.frame);

        //ImageListAdapter imageListAdapter = new ImageListAdapter(getActivity(), eatFoodyImages);
        flingContainer.setAdapter(arrayAdpt);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener(){


            @Override
            public void removeFirstObjectInAdapter() {
                //simplest way to delete an object from the adapater
                Log.d("LIST", "removed object!");
                rowItems.remove(0);
                arrayAdpt.notifyDataSetChanged();;
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

//                             if(dataObject.equals("WELCOME TO SAVVY! Get to Swiping!")) return;


                //Card we're swiping on should match with currently logged in user
                Cards card = (Cards)dataObject;
                final String selectedUserId = card.getUserId();


                fStore.collection("users").document(mAuth.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            final DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                originaFirebaseMatches =  new HashMap<String, Boolean>();

                                //Add original Data
                                if(document.get("matches") != null)
                                    originaFirebaseMatches.putAll((HashMap)document.get("matches")); //Plus copy previous information

                                //If it doesn't contain the userId insert a new Map enetry
                                if(!originaFirebaseMatches.containsKey(selectedUserId))
                                    originaFirebaseMatches.put(selectedUserId, false);

                                //Compare with selected User Data
                                fStore.collection("users").document(selectedUserId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                                        DocumentSnapshot documentSelectedUser = task.getResult();
                                        if(documentSelectedUser.exists()) {

                                            HashMap<String, Boolean> selectedFireBaseMatches = new HashMap<String, Boolean>();
                                            if((HashMap)documentSelectedUser.get("matches") != null)
                                                selectedFireBaseMatches.putAll((HashMap)documentSelectedUser.get("matches"));

                                            //WE HAVE A MATCH
                                            if(selectedFireBaseMatches.containsKey(mAuth.getUid())) {
                                                selectedFireBaseMatches.put(mAuth.getUid(), true);
                                                originaFirebaseMatches.put(selectedUserId, true);

                                                //Update Selected
                                                fStore.collection("users").document(selectedUserId).update("matches",selectedFireBaseMatches);

                                                //Update Original
                                                fStore.collection("users").document(mAuth.getUid()).update("matches", originaFirebaseMatches);
                                            }
                                            else {

                                                fStore.collection("users").document(mAuth.getUid()).update("matches", originaFirebaseMatches);
                                            }
                                        }
                                    }
                                });



                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                    }
                });


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
                //TODO Put the rowItems reseter down here
                rowItems.addAll(rowItemsCopy);
                arrayAdpt.notifyDataSetChanged();
                Log.d("List", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent){
                Toast.makeText(getActivity(), "click!", Toast.LENGTH_LONG).show();


                //TODO Find a better solution to more accurate click detector
                //Quick fix to detect click
                if(scrollProgressPercent == 0){
                    //goToDetailedUserSelection();
                    Log.d(TAG, "click!");
                    goToDetailedUserSelection();
                }
            }
        });

    }

    private void goToDetailedUserSelection() {
        Intent i = new Intent(getActivity(), DetailedUserSelection.class);
        i.putExtra("detailedUserId", rowItems.get(0).getUserId());
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

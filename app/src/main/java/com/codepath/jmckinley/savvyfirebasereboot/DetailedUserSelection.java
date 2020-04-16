package com.codepath.jmckinley.savvyfirebasereboot;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class DetailedUserSelection extends AppCompatActivity {

    final String TAG = "DetailedUserSelection";

    FirebaseFirestore fireStore;
    FirebaseAuth mAuth;

    TextView briefBio;
    TextView universityName;
    TextView skills;
    ImageView resumeView;

    TextView userName;
    TextView major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_user_selection);

        fireStore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() == null){
            goToMainActivity();
        }

        this.briefBio = findViewById(R.id.userSelectionBriefBio);
        this.universityName = findViewById(R.id.userSelectionUniveristy);
        this.skills = findViewById(R.id.userSelectionDisplaySkills);
        this.resumeView = findViewById(R.id.userSelectionResumeView);

        this.userName = findViewById(R.id.includedTest).findViewById(R.id.profileHeaderName);
        this.major = findViewById(R.id.includedTest).findViewById(R.id.profileHeaderMajor);
        //Loads in Profile Image
        ImageView iv = findViewById(R.id.includedTest).findViewById(R.id.detailedUserSelectionPhoto);
        String imageUrl = "https://www.gannett-cdn.com/presto/2019/09/11/USAT/ab5c4363-b8ec-40b4-a617-4e0b08a3aa4b-AP_Kevin_Hart_Crash.JPG";
        Picasso.get().load(imageUrl).into(iv);

        loadUserDetails();

    }

    public boolean loadUserDetails(){

        final DocumentReference docRef = fireStore.collection("users").document(mAuth.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());


                        //Loads information into layout
                        userName.setText(document.get("firstName").toString() + " " + document.get("lastName").toString());
                        major.setText(document.get("major").toString());
                        briefBio.setText(document.get("briefBio").toString());
                        universityName.setText(document.get("School").toString());


                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

        return true;
    }


    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity_.class);
        startActivity(i);
    }
}

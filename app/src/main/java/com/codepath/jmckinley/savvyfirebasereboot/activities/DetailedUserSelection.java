package com.codepath.jmckinley.savvyfirebasereboot.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.ImageView;
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

//        if(mAuth.getCurrentUser() == null){
//            goToMainActivity_();
//        }

        this.briefBio = findViewById(R.id.userSelectionBriefBio);
        this.universityName = findViewById(R.id.userSelectionUniveristy);
        this.skills = findViewById(R.id.userSelectionDisplaySkills);
        this.resumeView = findViewById(R.id.userSelectionResumeView);

        this.userName = findViewById(R.id.includedTest).findViewById(R.id.profileHeaderName);
        this.major = findViewById(R.id.includedTest).findViewById(R.id.profileHeaderMajor);


        loadUserDetails();

    }

    public boolean loadUserDetails(){

        Intent intent = getIntent();
        String selectedUserId = intent.getStringExtra("detailedUserId");

        final DocumentReference docRef = fireStore.collection("users").document(selectedUserId);
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
                        briefBio.setText(document.get("about").toString());
                        universityName.setText(document.get("university").toString());

                        //Loads in Profile Image
                        ImageView iv = findViewById(R.id.includedTest).findViewById(R.id.detailedUserSelectionPhoto);
                        String imageUrl = document.get("profileImage").toString();
                        Picasso.get().load(imageUrl).into(iv);

                        resumeView = findViewById(R.id.userSelectionResumeView);
                        imageUrl = document.get("resume").toString(); //Create a new field that creates images of users resumes
                        Picasso.get().load(imageUrl).into(resumeView);

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

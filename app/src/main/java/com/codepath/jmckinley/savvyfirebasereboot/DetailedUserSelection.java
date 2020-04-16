package com.codepath.jmckinley.savvyfirebasereboot;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class DetailedUserSelection extends AppCompatActivity {

    FirebaseFirestore fireStore;
    FirebaseAuth mAuth;

    TextView briefBio;
    TextView universityName;
    TextView skills;
    ImageView resumeView;

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



    }


    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity_.class);
        startActivity(i);
    }
}

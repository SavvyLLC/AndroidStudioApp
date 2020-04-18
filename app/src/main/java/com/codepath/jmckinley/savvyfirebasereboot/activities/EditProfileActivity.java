package com.codepath.jmckinley.savvyfirebasereboot.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class EditProfileActivity extends AppCompatActivity {

    public static final String TAG = "EditProfileActivity";

    private FirebaseFirestore fStore;
    private FirebaseAuth mAuth;
    private String userId;

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etMajor;
    private EditText etUniversity;
    private EditText etBriefBio;
    private Button btnUploadResume;
    private Button btnCancel;
    private Button btnSubmit;
    private Button btnSignout;
    private ImageView ivProfileImage;

    RadioGroup radioGroup;
    RadioButton isCompanyRadioBtn;
    RadioButton isStudentRadioBtn;

    boolean isCompanyInitialValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // connect Firebase Objects
        fStore = FirebaseFirestore.getInstance();       // Initialize Firestore
        mAuth = FirebaseAuth.getInstance();             // initialize auth

        // connect layout objects to java file
        etFirstName = findViewById(R.id.editProfileFirstName);
        etLastName = findViewById(R.id.editProfileLastName);
        etMajor = findViewById(R.id.editProfileMajor);
        etUniversity = findViewById(R.id.editProfileUniversity);
        etBriefBio = findViewById(R.id.editProfileBriefBio);
        btnUploadResume = findViewById(R.id.button_UploadResume);
        btnCancel = findViewById(R.id.editProfileCancel);
        btnSubmit = findViewById(R.id.editProfileSubmitButton);
        btnSignout = findViewById(R.id.editProfileSignOut);
        ivProfileImage = findViewById(R.id.editProfileUserImage);
        String imageUrl = "https://www.gannett-cdn.com/presto/2019/09/11/USAT/ab5c4363-b8ec-40b4-a617-4e0b08a3aa4b-AP_Kevin_Hart_Crash.JPG";
        Picasso.get().load(imageUrl).into(ivProfileImage);

        radioGroup = findViewById(R.id.editProfileAccountTypeRadioGroup);
        isCompanyRadioBtn = findViewById(R.id.editProfileCompanyRadioButton);
        isStudentRadioBtn = findViewById(R.id.editProfileStudentRadioButton);

        //DocumentReference documentReference = fStore.collection("users").document(userId);
        loadUserDetailsIntoView();

        //Transitions to file upload screen
        btnUploadResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditProfileActivity.this, UploadDocuments.class);
                startActivity(i);
            }
        });


        // submit changes to database
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfileChanges();
                // TODO: set user profile image

                // TODO: update information in database
                Toast.makeText(EditProfileActivity.this, "Profile sucessfully updated - not yet though?", Toast.LENGTH_SHORT).show();
                goToMainActivity();

            }
        });

        // signout user
        btnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Member signing out");
                Toast.makeText(EditProfileActivity.this, "You are now logged out", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                goToLogin();
            }
        });

        // cancel edit
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "returning to main activity");
                goToMainActivity();
            }
        });

    }

    //TODO Do an error check for invalid fields going to documentReference
    public boolean updateProfileChanges(){

        final DocumentReference docRef = fStore.collection("users").document(mAuth.getUid());

        // Set the "isCapital" field of the city 'DC'
        docRef.update("firstName", etFirstName.getText().toString().trim());
        docRef.update("lastName", etLastName.getText().toString().trim());
        docRef.update("major", etMajor.getText().toString().trim());
        docRef.update("School", etUniversity.getText().toString().trim());
        docRef.update("briefBio", etBriefBio.getText().toString().trim());

        //If they don't equal, there was a change in account type
        if(isCompanyInitialValue != isCompanyRadioBtn.isChecked()){
            docRef.update("isCompany", !isCompanyInitialValue);
        }


        return true;
    }

    /*
    Pulls from Firebase to load the users details into the view
     */
    public boolean loadUserDetailsIntoView(){

        final DocumentReference docRef = fStore.collection("users").document(mAuth.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());


                        //Loads information into layout
                        etFirstName.setText(document.get("firstName").toString());
                        etLastName.setText(document.get("lastName").toString());
                        etMajor.setText(document.get("major").toString());
                        etUniversity.setText(document.get("School").toString());
                        etBriefBio.setText(document.get("briefBio").toString());

                        boolean isCompany = (boolean)document.get("isCompany");
                        if(isCompany) {
                            isStudentRadioBtn.setChecked(false);
                            isCompanyRadioBtn.setChecked(true);
                            isCompanyInitialValue = true;
                        }
                        else {
                            isCompanyRadioBtn.setChecked(false);
                            isStudentRadioBtn.setChecked(true);
                            isCompanyInitialValue= false;
                        }


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

    public void updateProfile(){
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDbRef = mDatabase.getReference();

    }

    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity_.class);
        startActivity(i);
        //finish();

    }

    private void goToLogin() {
        Intent i = new Intent(this, SignInActivity.class);
        startActivity(i);
       // finish();
    }
}

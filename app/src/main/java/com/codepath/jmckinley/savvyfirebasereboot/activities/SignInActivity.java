package com.codepath.jmckinley.savvyfirebasereboot.activities;

import android.content.Intent;
import android.os.Bundle;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    EditText userEmail;
    EditText userPassword;

    Button signInButton;
    Button signUpButton;

    FirebaseAuth mAuth;

    final public String TAG = "SignInActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        this.userEmail = findViewById(R.id.signInEmail);
        this.userPassword = findViewById(R.id.signInPassword);
        this.signInButton = findViewById(R.id.signInButton);
        this.signUpButton = findViewById(R.id.newUserSignUpButton);

        mAuth = FirebaseAuth.getInstance();

        // check if user is currently signed in
        if (mAuth.getCurrentUser() != null) {
            goToMainActivity();
            finish();
        }

        this.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkForRequredEntriesAreFilled())
                    signInUser();
            }
        });

        this.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntentToSignUp();
            }
        });
    }


    /*
   Makes sure everything that's required by the user is filled in
    */
    public boolean checkForRequredEntriesAreFilled(){
        //Checks String Entries
        //schoolName is talking about toString()
        if(this.userEmail.getText().toString() == "" || this.userPassword.getText().toString() == "" ){
            Toast.makeText(this, "An Entry was left blank", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    /*
    Starts the SignUpActivity Screen
     */
    public boolean startIntentToSignUp(){
        Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(i);


        return true;
    }

    /*
    Starts the SignUpActivity Screen
     */
    public boolean startIntentToMainActivity(){
        Intent i = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(i);


        return true;
    }

    public boolean signInUser(){
        mAuth.signInWithEmailAndPassword(this.userEmail.getText().toString(), this.userPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            goToMainActivity();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });

        return true;

    }

    // use intent system to navigate to Main activity
    private void goToMainActivity() {
        // TODO: change MainActivity_ -> MainActivity
        // TODO: currently testing and debuging message feature on MainActivity_
        Intent i = new Intent(this, MainActivity_.class);
        startActivity(i);
        finish();
    }


}

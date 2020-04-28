package com.codepath.jmckinley.savvyfirebasereboot.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.codepath.jmckinley.savvyfirebasereboot.Models.Users
import com.codepath.jmckinley.savvyfirebasereboot.R
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val TAG: String = "RegisterActivity"

    // Access a Cloud Firestore instance from your Activity
    val firestoreDB = FirebaseFirestore.getInstance()

    private lateinit var mAuth: FirebaseAuth
    private var firebaseUserId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        // set title and back navigation on toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar_register)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Register"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener{
            // navigation to activity when back navigation is used
            val intent = Intent(this@RegisterActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        // get the current user
        mAuth = FirebaseAuth.getInstance()

        // start register method
        register_btn.setOnClickListener {
            registerUser()
        }

    }

    private fun registerUser(){
        // capture input from text fields
        val username: String = username_register.text.toString()
        val email: String = email_register.text.toString()
        val password: String = password_register.text.toString()

        // check that fields are completed
        if (username.equals("")) {
            Toast.makeText(this@RegisterActivity, "username cannot be empty.", Toast.LENGTH_LONG).show()
        } else if (email.equals("")) {
            Toast.makeText(this@RegisterActivity, "email cannot be empty.", Toast.LENGTH_LONG).show()
        } else if (password.equals("")) {
            Toast.makeText(this@RegisterActivity, "password cannot be empty.", Toast.LENGTH_LONG).show()
        } else {
            // create and authorize new user
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // capture the users unique id
                            firebaseUserId = mAuth.currentUser!!.uid

//                            var user: Users = Users(firebaseUserId,
//                                    "https://firebasestorage.googleapis.com/v0/b/savvyllcreboot.appspot.com/o/coverphoto.jpeg?alt=media&token=4f087d69-e669-4d5c-8b62-2c138b14b462",
//                                    "https://m.facebook.com",
//                                    "https://firebasestorage.googleapis.com/v0/b/savvyllcreboot.appspot.com/o/profileimage.jpeg?alt=media&token=4235769f-0e2d-40ec-aacb-931b5d2c56b8",
//                                    username.toLowerCase(),
//                                    "offline",
//                                    username,
//                                    "http://www.isaiahmcnealy.com")



//                          create  a hashmap to create a document
                            val userHashMap = HashMap<String, Any>()

                            // set user information
                            userHashMap["uid"] = firebaseUserId
                            userHashMap["username"] = username
                            userHashMap["profileImage"] = "https://firebasestorage.googleapis.com/v0/b/savvyllcreboot.appspot.com/o/profileimage.jpeg?alt=media&token=4235769f-0e2d-40ec-aacb-931b5d2c56b8"
                            userHashMap["coverImage"] = "https://firebasestorage.googleapis.com/v0/b/savvyllcreboot.appspot.com/o/coverphoto.jpeg?alt=media&token=4f087d69-e669-4d5c-8b62-2c138b14b462"
                            userHashMap["onlineStatus"] = "offline"
                            userHashMap["search"] = username.toLowerCase()
                            userHashMap["linkedin"] = "https://m.linkedin.com"
                            userHashMap["website"] = "http://www.isaiahmcnealy.com"
                            userHashMap["about"] = "In a galaxy far far away..."
                            userHashMap["firstName"] = "firstname"
                            userHashMap["lastName"] = "lastname"
                            userHashMap["isCompany"] = false
                            userHashMap["resume"] = "filepath"
                            //TODO: create a skills subcollection and allow users to select with buttons
//                            userHashMap["skills"] = ""

                            // fit the assigned data to the current user's document
                            firestoreDB.collection("users")
                                    .document(firebaseUserId)
                                    .set(userHashMap)
                                    // check for successful input
                                    .addOnSuccessListener(OnSuccessListener {
                                        Log.d("RegisterActivity", "DocumentSnapshot successfully written!")
                                    })
                                    .addOnFailureListener(OnFailureListener {
                                        e -> Log.w("RegisterActivity", "Error writing document", e)
                                    })
                                    // when data is finished writing
                                    .addOnCompleteListener {
                                        if (task.isSuccessful){
                                            // navigate back to main activity
                                            val intent = Intent(this@RegisterActivity, SignUpActivity::class.java)
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                                            startActivity(intent)
                                            finish()
                                        }
                                    }
//

                        } else {
                            Toast.makeText(this@RegisterActivity, "Error Message: " + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
        }
    }
}
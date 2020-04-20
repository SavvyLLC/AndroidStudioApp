package com.codepath.jmckinley.savvyfirebasereboot.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codepath.jmckinley.savvyfirebasereboot.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : AppCompatActivity() {

    // declare instance of firebase
    var firebaseUser: FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        register_welcome_btn.setOnClickListener{
            val intent = Intent(this@WelcomeActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        login_welcome_btn.setOnClickListener{
            val intent = Intent(this@WelcomeActivity, Login2Activity::class.java)
            startActivity(intent)
            finish()
        }



    }

    override fun onStart() {
        super.onStart()
        // initialize instance of firebase
        firebaseUser = FirebaseAuth.getInstance().currentUser   // grab current user token

        // if there is a user signed in (token is not empty) then navigate to main activity
        if(firebaseUser != null) {
            val intent = Intent(this@WelcomeActivity, MainActivity_::class.java)
            startActivity(intent)
            finish()
        }


    }



}

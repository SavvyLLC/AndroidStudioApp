package com.codepath.jmckinley.savvyfirebasereboot.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.codepath.jmckinley.savvyfirebasereboot.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login2.*
import kotlinx.android.synthetic.main.activity_login2.login_btn
import kotlinx.android.synthetic.main.activity_register.*

class Login2Activity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        // set title and back navigation on toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar_login)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Login"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener{
            // navigation to activity when back navigation is used
            val intent = Intent(this@Login2Activity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }



        mAuth = FirebaseAuth.getInstance()

        login_btn.setOnClickListener({
            loginUser()
        })

    }

    private fun loginUser() {
        val email: String = email_login.text.toString()
        val password: String = password_login.text.toString()

        if (email.equals("")) {
            Toast.makeText(this@Login2Activity, "email cannot be empty.", Toast.LENGTH_LONG).show()

        } else if (password.equals("")) {
             Toast.makeText(this@Login2Activity, "password cannot be empty.", Toast.LENGTH_LONG).show()

        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener{ task ->
                        if(task.isSuccessful){

                            val intent = Intent(this@Login2Activity, MainActivity_::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()

                        } else {
                            Toast.makeText(this@Login2Activity, "Error Message: " + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
        }
    }
}

package com.codepath.jmckinley.savvyfirebasereboot.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codepath.jmckinley.savvyfirebasereboot.Models.Users

import com.codepath.jmckinley.savvyfirebasereboot.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_.*
import kotlinx.android.synthetic.main.fragment_settings.*

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment() {

    val TAG: String = "MainActivity_"

    var firestoreDB = FirebaseFirestore.getInstance()
    var fireBaseUser: FirebaseUser? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
//
//        fireBaseUser = FirebaseAuth.getInstance().currentUser
//        val docRef = firestoreDB.collection("users").document(fireBaseUser!!.uid)
//        docRef.get()
//                .addOnSuccessListener { documentSnapshot ->
//                    if(documentSnapshot.exists()){
//                        // store snapshot into
//                        val user: Users? = documentSnapshot.toObject(Users::class.java)
//
//
//                        // get profile image and username to display on toolbar
//                        username_settings.text = user!!.getUsername()
//                        Picasso.get().load(user.getProfileImage()).placeholder(R.drawable.profileimage).into(profile_image_settings)
//                        Picasso.get().load(user.getProfileImage()).placeholder(R.drawable.profileimage).into(cover_image_settings)
//                    }
//                }


        return view
    }

}

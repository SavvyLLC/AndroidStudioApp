package com.codepath.jmckinley.savvyfirebasereboot.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codepath.jmckinley.savvyfirebasereboot.Models.Users

import com.codepath.jmckinley.savvyfirebasereboot.R
import com.codepath.jmckinley.savvyfirebasereboot.adapters.UserAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {


    private var userAdapter: UserAdapter? = null
    private var mUsers: List<Users>? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_search, container, false)

        mUsers = ArrayList()
        retrieveAllUsers()



        return view
    }

    private fun retrieveAllUsers() {
        var firebaseUser = FirebaseAuth.getInstance().currentUser!!.uid
    }

}

package com.codepath.jmckinley.savvyfirebasereboot.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.jmckinley.savvyfirebasereboot.Models.Users
import com.codepath.jmckinley.savvyfirebasereboot.R
import com.codepath.jmckinley.savvyfirebasereboot.adapters.UserAdapter
import com.codepath.jmckinley.savvyfirebasereboot.fragments.SwipeFragment.TAG
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

/**
 * TODO: This fragment will display all the users that you have matched with
 * TODO: Swap from pulling in all users to only pulling in users that are flagged as matches
 * TODO: When a user is tapped navigate to the MessageChatActivity where the message will be directed to that user
 */
class SearchFragment : Fragment() {

    private val TAG: String = "SearchFragment"

    private var userAdapter: UserAdapter? = null
    private var mUsers: List<Users>? = null
    private var recyclerView: RecyclerView? = null
    private var search_users_et: EditText? = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_search, container, false)

        recyclerView = view.findViewById(R.id.searchList)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        search_users_et = view.findViewById(R.id.search_users_et)

        mUsers = ArrayList()    // a list of users to be displayed
        retrieveAllUsers()

        // when user starts typing in the chat
        search_users_et!!.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
             }

            // when the text is changed do this
            override fun onTextChanged(cs: CharSequence?, start: Int, before: Int, count: Int) {
                searchForUser(cs.toString().toLowerCase())
             }
        })

        return view
    }

    private inline fun <reified T> genericCastOrNull(anything: Any):T? {
        return anything as? T
    }

    // retrieve all the users from FireStore
    private fun retrieveAllUsers() {
        var firebaseUserID = FirebaseAuth.getInstance().currentUser!!.uid


        /*
        Performs Query for getting the matches for the current user
         */

        val refUsers = FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().uid.toString())
        refUsers.get()
                .addOnSuccessListener { document ->
                    if (document != null) {

                        //TODO Check the matches for current user
                        var matches = HashMap<String, Boolean>()

                        //Gets matches for user
                        matches = document["matches"] as HashMap<String, Boolean>
                        for ((key, value) in matches) {
                            println("$key = $value")

                            Log.d(TAG, "$key = $value")

                            //If true, there's a match
                            if(value){

                                FirebaseFirestore.getInstance().collection("users").document(key)
                                        .get()
                                        .addOnSuccessListener { documentSnapshot ->
                                            if(documentSnapshot != null){

                                                // log all users and their documents ( should include current user)
                                                Log.d(TAG, "Queried  data: ${documentSnapshot.id} => ${documentSnapshot.data}")

                                                val user: Users? = documentSnapshot.toObject(Users::class.java)
                                                // if user[i] is not the current user
                                                //TODO Not needed since these queries are from people we don't know
                                                if(!(user!!.getUID()).equals(firebaseUserID)){
                                                    // add user to the arrayList of users
                                                    (mUsers as ArrayList<Users>).add(user)
                                                }
                                            }
                                        }
                            }
                        }

                        // bind the users to recyclerview using user adapter
                        userAdapter = UserAdapter(requireContext(), mUsers!!, false)
                        recyclerView!!.adapter = userAdapter
                        Log.d(TAG, "Display Current User: ${firebaseUserID} ")

                        // log all the users to be displayed in LogCat (should exclude current user)
                        for (users in mUsers as ArrayList<Users>){
                            Log.d(TAG, "Display userList: ${users.getUID()}")
                        }

                        Log.d(TAG, "DocumentSnapshot data for current user: ${document.data}")
                    } else {
                        Log.d(TAG, "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d(TAG, "get failed with ", exception)
                }

        // When data is changed in the collection
//        refUsers.addSnapshotListener { snapshot, e ->
//            // if there is an error; log the message
//            if (e != null) {
//                Log.w(TAG, "Listen failed.", e)
//                return@addSnapshotListener
//            }
//
//            // if there is data in the snapshot
//            if (snapshot != null) {
//                Log.d(TAG, "Current data: ${snapshot}")
//
//                // clear array list
//                (mUsers as ArrayList<Users>).clear()
//                // if search bar is NOT empty
//                if (search_users_et!!.text.toString() == "")
//
//                // Query snapshot data
//                refUsers.get()
//                        // if successfull
//                        .addOnSuccessListener { documents ->
//                            // for all the users in a collection
//                            for (document in documents)
//                            {
//                                // log all users and their documents ( should include current user)
//                                Log.d(TAG, "Queried  data: ${document.id} => ${document.data}")
//
//                                val user: Users? = document.toObject(Users::class.java)
//                                // if user[i] is not the current user
//                                if(!(user!!.getUID()).equals(firebaseUserID)){
//                                    // add user to the arrayList of users
//                                    (mUsers as ArrayList<Users>).add(user)
//                                }
//
//                            }
//
//
//
//                        }
//
//                        .addOnFailureListener { exception ->
//                            Log.w(TAG, "Error getting documents: ", exception)
//                        }
//
//            } else {
//                Log.d(TAG, "Current data: null")
//            }

        //}   // end snapShotListener

    }   // end method

    private fun searchForUser (str: String) {

        // reference to current user and the collection of users
        var firebaseUserID = FirebaseAuth.getInstance().currentUser!!.uid
        val queryUsers = FirebaseFirestore.getInstance().collection("users")
                .orderBy("search")
                .startAt(str)
                .endAt(str + "\uf8ff")

        // When data is changed in the collection
        queryUsers.addSnapshotListener { snapshot, e ->
            // if there is an error; log the message
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }
            // there is data in the snapshot
            if (snapshot != null) {
                Log.d(TAG, "Current data: ${snapshot}")

                // clear array list
                (mUsers as ArrayList<Users>).clear()

                // Query snapshot data
                queryUsers.get()

                        // if successfull
                        .addOnSuccessListener { documents ->

                            // for all the users in a collection
                            for (document in documents) {

                                // log all users and their document
                                Log.d(TAG, "Queried  data: ${document.id} => ${document.data}")
                                val user: Users? = document.toObject(Users::class.java)

                                // if user[i] is not the current user
                                if (!(user!!.getUID()).equals(firebaseUserID)) {

                                    // add user to the arrayList of users
                                    (mUsers as ArrayList<Users>).add(user)
                                }
                            }

                        } // end addOnSuccecssListener
            } else {
                Log.d(TAG, "Current data: null")
            }    // end else

        }   // end snapShotListener

    }   // end method

}   // end class

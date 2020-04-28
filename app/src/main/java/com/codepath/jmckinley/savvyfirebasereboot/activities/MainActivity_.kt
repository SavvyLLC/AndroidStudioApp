package com.codepath.jmckinley.savvyfirebasereboot.activities

//import android.widget.Toolbar
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.codepath.jmckinley.savvyfirebasereboot.Models.Users
import com.codepath.jmckinley.savvyfirebasereboot.R
import com.codepath.jmckinley.savvyfirebasereboot.fragments.CallFragment
import com.codepath.jmckinley.savvyfirebasereboot.fragments.SearchFragment
import com.codepath.jmckinley.savvyfirebasereboot.fragments.SettingsFragment
import com.codepath.jmckinley.savvyfirebasereboot.fragments.SwipeFragment
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_.*

class MainActivity_ : AppCompatActivity() {

    val TAG: String = "MainActivity_"
    var fireBaseUser: FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_)
        setSupportActionBar(findViewById(R.id.toolbar_main))

        // TODO: Remove this code after implementing messaging
        val intent = Intent()

        // create reference to firestore
        fireBaseUser = FirebaseAuth.getInstance().currentUser
        var firestoreDB = FirebaseFirestore.getInstance()

        val docRef = firestoreDB.collection("users").document(fireBaseUser!!.uid)
        docRef.get()
                .addOnSuccessListener { documentSnapshot ->
                    if(documentSnapshot.exists()){
                        // store snapshot into p0
                        val userSnapshot = documentSnapshot.toObject(Users::class.java)

                        // get profile image and username to display on toolbar
                        // TODO: Check that user has an image and username
//                        user_name.text = userSnapshot!!.getUsername()
//                        Picasso.get().load(userSnapshot.getProfileImage()).placeholder(R.drawable.profileimage).into(profile_image)
                    }
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.addFragments(SwipeFragment(), "Explore")
        viewPagerAdapter.addFragments(CallFragment(), "Call")
        viewPagerAdapter.addFragments(SearchFragment(), "Matches")
        viewPagerAdapter.addFragments(SettingsFragment(), "Settings")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the home/up button so long
        // as you specify a parent activity in AndroidManifest
        when (item.itemId) {
            // when the logout item is selected
            R.id.action_logout -> {
                // sign out current user
                FirebaseAuth.getInstance().signOut()
                // navigate to welcome activity
                val intent = Intent(this@MainActivity_, WelcomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()

                return true
            }

        }

        return false
    }

    internal class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        private val fragments: ArrayList<Fragment>
        private val titles: ArrayList<String>

        init {
            fragments = ArrayList<Fragment>()
            titles = ArrayList<String>()
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }


        override fun getCount(): Int {
            return fragments.size
        }

        fun addFragments(fragment: Fragment, title: String) {

            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }
    }

}
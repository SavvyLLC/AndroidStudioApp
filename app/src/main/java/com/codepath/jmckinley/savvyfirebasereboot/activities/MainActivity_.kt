package com.codepath.jmckinley.savvyfirebasereboot.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
//import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.codepath.jmckinley.savvyfirebasereboot.R
import com.codepath.jmckinley.savvyfirebasereboot.fragments.ChatsFragment
import com.codepath.jmckinley.savvyfirebasereboot.fragments.SearchFragment
import com.codepath.jmckinley.savvyfirebasereboot.fragments.SettingsFragment
import com.google.android.material.tabs.TabLayout

class MainActivity_ : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_)
        setSupportActionBar(findViewById(R.id.toolbar_main))

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragments(ChatsFragment(), "Chats")
        viewPagerAdapter.addFragments(SearchFragment(), "Search")
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
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
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
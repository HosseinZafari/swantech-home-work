package com.example.drawermenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.util.Log
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.drawermenu.fragment.HomeFragment
import com.example.drawermenu.fragment.PersonFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navigationView: NavigationView
    lateinit var drawer: DrawerLayout
    lateinit var actionBarDrawerToggle : ActionBarDrawerToggle
//    lateinit var frameLayout: FrameLayout
    val personFragment = PersonFragment()
    val homeFragment = HomeFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        navigationView = findViewById<NavigationView>(R.id.nav_main)
        drawer = findViewById<DrawerLayout>(R.id.drawer)
//        frameLayout = findViewById<FrameLayout>(R.id.frame_view_main)
        navigationView.setCheckedItem(R.id.menu_feed)

        actionBarDrawerToggle = ActionBarDrawerToggle(this , drawer , R.string.open , R.string.close)
        drawer.addDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val header = navigationView.getHeaderView(0)
        val imgButton = header.findViewById<ImageButton>(R.id.img_close)

        imgButton.setOnClickListener {
            drawer.closeDrawer(GravityCompat.START)
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_view_main , homeFragment  , "Home")
            .commit()

        navigationView.setNavigationItemSelectedListener {
            it.setChecked(true)
            setTitle(it.title)
            return@setNavigationItemSelectedListener when(it.itemId)  {
                R.id.menu_feed -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_view_main , homeFragment  , "Home")
                        .commit()
                        drawer.closeDrawers()
                    Log.i("Test" , "Menu Feed")
                    true
                }

                R.id.menu_person -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_view_main , personFragment , "Person")
                        .commit()
                        drawer.closeDrawers()
                    Log.i("Test" , "Menu person")
                    true
                }
                R.id.menu_event -> {
                    Log.i("Test" , "Menu event")
                    true
                }

                R.id.menu_logout -> {
                    Log.i("Test" , "Menu logout")
                    true
                }

                R.id.menu_post -> {
                    Log.i("Test" , "Menu post")
                    true
                }

                R.id.menu_notification -> {
                    Log.i("Test" , "Menu notification")
                    true
                }
                else -> false
            }

        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return actionBarDrawerToggle.onOptionsItemSelected(item)
    }
}
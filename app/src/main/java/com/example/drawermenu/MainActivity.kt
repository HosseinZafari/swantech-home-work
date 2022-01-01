package com.example.drawermenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.example.drawermenu.fragments.EngineFragment
import com.example.drawermenu.fragments.HomeFragment
import com.example.drawermenu.fragments.ProfileFragment
import com.example.drawermenu.fragments.TimeFragment

/*

@created in 01/01/2022 - 10:58 AM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var profileFragment: ProfileFragment
    lateinit var timeFragment: TimeFragment
    lateinit var engineFragment: EngineFragment
    lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        homeFragment = HomeFragment (::onNavigate)
        engineFragment = EngineFragment(::onNavigate)
        profileFragment = ProfileFragment()
        timeFragment = TimeFragment()

        goTo(homeFragment , "Home")
    }

    fun goTo(fragment: Fragment , tag: String ) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_main , fragment  , tag)
            .commit()
        currentFragment = fragment
    }

    private fun onNavigate(navigate: Navigate) {
        when (navigate) {
            Navigate.Profile -> {
                goTo(profileFragment , "Profile")
            }

            Navigate.Report -> {
                goTo(profileFragment , "Profile")
            }

            Navigate.Engine -> {
                goTo(engineFragment , "Engine")
            }

            Navigate.TimeItem -> {
                goTo(timeFragment, "Time")
            }
        }
    }

    override fun onBackPressed() {
        if (currentFragment !is HomeFragment) {
            goTo(homeFragment , "Home")
        } else {
            super.onBackPressed()
        }
    }

}
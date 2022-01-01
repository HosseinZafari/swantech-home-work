package com.example.drawermenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.drawermenu.adapter.AuthFragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/*

@created in 01/01/2022 - 10:56 AM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class AuthActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)


        val tablayout = findViewById<TabLayout>(R.id.tb_layout)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val tabNames = listOf("User" , "Manager")

        val adapter = AuthFragmentStateAdapter(this)
        viewPager.adapter = adapter


        TabLayoutMediator(tablayout , viewPager ) { tab , position ->
            val name = tabNames[position]
            tab.text = name
        }.attach()

    }
}
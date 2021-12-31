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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.adapter.EngineAdapter
import com.example.drawermenu.adapter.TimeAdapter
import com.google.android.material.navigation.NavigationView

class TimeActivity : AppCompatActivity() {

    val adapter = TimeAdapter(this )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val rv_time = findViewById<RecyclerView>(R.id.rv_time)
        rv_time.layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false)
        rv_time.adapter = adapter
        adapter.data = getData().toMutableList()

    }



    fun getData() = listOf(
        "02:00" ,
        "02:20" ,
        "22:00" ,
        "05:30" ,
        "12:00" ,
        "11:00" ,
        "5:00" ,
    )

}
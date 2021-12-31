package com.example.drawermenu

import android.content.Intent
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
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    val adapter = EngineAdapter(this , ::onClickEvent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rv_engine = findViewById<RecyclerView>(R.id.rv_engine)
        rv_engine.layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false)
        rv_engine.adapter = adapter
        adapter.data = getData().toMutableList()
    }

    fun onClickEvent(str: String) {
        val bundle = Bundle()
        bundle.putString("engine"  , str)
        val intent = Intent(this , TimeActivity::class.java )
        intent.putExtra("bun" , bundle)
        startActivity(intent)
    }

    fun getData() = listOf(
        "Engine 1" ,
        "Engine 2" ,
        "Engine 3" ,
        "Engine 4" ,
        "Engine 5" ,
        "Engine 6" ,
        "Engine 7" ,
    )

}
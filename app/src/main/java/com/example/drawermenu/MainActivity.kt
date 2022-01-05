package com.example.drawermenu

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.drawermenu.adapter.PagerTabAdapter
import com.example.drawermenu.fragment.WebFragment
import com.example.drawermenu.fragment.LinkFragment
import com.example.drawermenu.fragment.VideoFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val pagerTabAdapter = PagerTabAdapter(this , ::onLongClickBrowser)
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private val titleList = listOf(
        "Browser" ,
        "Last Seen" ,
        "Play Video"
    )

    companion object {
        var url_video = ""
        var videoList = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupViews()

    }

    private fun setupViews() {
        viewPager = findViewById<ViewPager2>(R.id.viewpager_main)
        tabLayout = findViewById<TabLayout>(R.id.tablayout_main)

        viewPager.adapter = pagerTabAdapter
        TabLayoutMediator(tabLayout , viewPager , true) { tab , index ->
            val title = titleList[index]
            tab.text  = title
        }.attach()

    }



    private fun onLongClickBrowser(link: String) {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val data = ClipData.newPlainText("urlvideo" , link)
        clipboardManager.setPrimaryClip(data)


        Toast.makeText(this , "لینک شما کپی شد" , Toast.LENGTH_LONG).show()
        viewPager.currentItem = 2
    }
}
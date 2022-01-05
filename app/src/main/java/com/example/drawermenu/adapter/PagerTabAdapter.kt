package com.example.drawermenu.adapter

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.drawermenu.fragment.LinkFragment
import com.example.drawermenu.fragment.VideoFragment
import com.example.drawermenu.fragment.WebFragment

/*

@created in 03/01/2022 - 5:08 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class PagerTabAdapter(
    fragmentActivity: FragmentActivity ,
    val onLongClickBrowser: (String) -> Unit ,
) : FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WebFragment(onLongClick = onLongClickBrowser)

            1 -> LinkFragment()

            else -> VideoFragment()
        }
    }
}
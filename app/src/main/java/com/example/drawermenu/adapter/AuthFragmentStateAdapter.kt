package com.example.drawermenu.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.drawermenu.fragments.UserFragment
import com.example.drawermenu.fragments.ManagerFragment

/*

@created in 01/01/2022 - 11:11 AM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class AuthFragmentStateAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int) = when (position) {
        0 -> UserFragment()
        else -> ManagerFragment()
    }


}
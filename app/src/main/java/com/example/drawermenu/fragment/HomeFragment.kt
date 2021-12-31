package com.example.drawermenu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.PersonModel
import com.example.drawermenu.R
import com.example.drawermenu.adapter.PersonAdapter

/*

@created in 30/12/2021 - 9:22 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }



}
package com.example.drawermenu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.MainActivity
import com.example.drawermenu.R
import com.example.drawermenu.adapter.LinkAdapter

/*

@created in 30/12/2021 - 9:22 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class LinkFragment : Fragment() {

    lateinit var linkAdapter: LinkAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        linkAdapter = LinkAdapter(requireContext())
        return inflater.inflate(R.layout.fragment_link, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews(view)
    }

    fun setupViews(view: View ) {
        val rv_link = view.findViewById<RecyclerView>(R.id.rv_link)
        rv_link.layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.VERTICAL , false)
        rv_link.adapter = linkAdapter
    }

    override fun onResume() {
        linkAdapter.data = MainActivity.videoList
        super.onResume()
    }


}
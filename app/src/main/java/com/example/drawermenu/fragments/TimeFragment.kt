package com.example.drawermenu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.R
import com.example.drawermenu.adapter.EngineAdapter
import com.example.drawermenu.adapter.TimeAdapter

class TimeFragment : Fragment() {

    private lateinit var adapter: TimeAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = TimeAdapter(requireContext())
        return  inflater.inflate(R.layout.activity_time , container , false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv_time = view.findViewById<RecyclerView>(R.id.rv_time)
        rv_time.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
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
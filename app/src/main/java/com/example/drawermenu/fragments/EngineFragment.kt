package com.example.drawermenu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.Navigate
import com.example.drawermenu.R
import com.example.drawermenu.adapter.EngineAdapter

class EngineFragment(
    val onNavigate: (Navigate) -> Unit ,
) : Fragment() {

    private lateinit var adapter: EngineAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = EngineAdapter(requireContext() , ::onClickEvent)
        return  inflater.inflate(R.layout.fragment_engine , container , false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv_engine = view.findViewById<RecyclerView>(R.id.rv_engine)
        rv_engine.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_engine.adapter = adapter
        adapter.data = getData().toMutableList()
    }


    fun onClickEvent(str: String) {
        onNavigate(Navigate.TimeItem)
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
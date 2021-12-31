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

class PersonFragment : Fragment() {


    private lateinit var  personAdapter: PersonAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        personAdapter = PersonAdapter(requireContext())
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews(view)
        personAdapter.data = getData().toMutableList()
    }

    fun setupViews(view: View ) {
        val rv_person = view.findViewById<RecyclerView>(R.id.rv_person)
        rv_person.adapter = personAdapter
        rv_person.layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.VERTICAL , false)
    }


    fun getData() = listOf<PersonModel>(
        PersonModel(22, "Hossein", "0903 54 90726", "Hossein@gmail.com"),
        PersonModel(54, "Ali", "0903 14 11255", "Ali@gmail.com"),
        PersonModel(53, "Mohamad", "0903 64 90721", "Mohamad@gmail.com"),
        PersonModel(24, "Reza", "0903 15 90726", "Reza@gmail.com"),
        PersonModel(55, "Mohamad 2", "0903 44 20751", "Mohamad@gmail.com"),
        PersonModel(11, "Omid", "0903 72 22726", "Elnaz@gmail.com"),
        PersonModel(14, "Elnaz", "0903 80 10726", "Omid@gmail.com"),
    )

}
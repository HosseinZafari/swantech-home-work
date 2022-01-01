package com.example.drawermenu.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.drawermenu.MainActivity
import com.example.drawermenu.R

/*

@created in 01/01/2022 - 11:01 AM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews(view)
    }

    private fun setupViews(view: View) {
        val txt_forgot = view.findViewById<TextView>(R.id.txt_forget)
        val btn_enter = view.findViewById<Button>(R.id.btn_enter)


        btn_enter.setOnClickListener (::onClickEvent)
    }



    fun onClickEvent(view: View) {
        val intent = Intent(requireContext() , MainActivity::class.java )
        startActivity(intent)
    }


}
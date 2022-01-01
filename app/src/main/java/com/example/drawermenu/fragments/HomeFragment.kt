package com.example.drawermenu.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.example.drawermenu.MainActivity
import com.example.drawermenu.Navigate
import com.example.drawermenu.R

/*

@created in 01/01/2022 - 11:01 AM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/


class HomeFragment (
    val onNavigate: (Navigate) -> Unit
) : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews(view)
    }

    private fun setupViews(view: View) {
        val card_profile = view.findViewById<LinearLayoutCompat>(R.id.card_profile)
        val card_output = view.findViewById<LinearLayoutCompat>(R.id.card_output)
        val card_parameter = view.findViewById<LinearLayoutCompat>(R.id.card_parameter)
        card_profile.setOnClickListener {
            onNavigate(Navigate.Profile)
        }

        card_parameter.setOnClickListener {
            onNavigate(Navigate.Engine)
        }

    }



    fun onClickEvent(view: View) {
        val intent = Intent(requireContext() , MainActivity::class.java )
        startActivity(intent)
    }

}
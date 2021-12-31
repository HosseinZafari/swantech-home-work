package com.example.drawermenu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.PersonModel
import com.example.drawermenu.R
import java.util.zip.Inflater

/*

@created in 31/12/2021 - 1:04 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class PersonAdapter (
    val context: Context
): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    var data = mutableListOf<PersonModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class PersonViewHolder(
        view: View ,
        val txt_name: TextView = view.findViewById(R.id.txt_name) ,
        val txt_phone: TextView = view.findViewById(R.id.txt_phone) ,
        val txt_email: TextView = view.findViewById(R.id.txt_email) ,
    ) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PersonViewHolder(LayoutInflater.from(context).inflate(R.layout.item_person , parent , false))

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val item = data[position]
        holder.apply {
            txt_name.text  = item.name
            txt_email.text = item.email
            txt_phone.text = item.phone
        }
    }

    override fun getItemCount() = data.size

}
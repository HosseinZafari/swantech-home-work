package com.example.drawermenu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.R

/*

@created in 03/01/2022 - 8:32 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class LinkAdapter(
    val context: Context
) : RecyclerView.Adapter<LinkAdapter.LinkViewHolder>() {

    var data = mutableListOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    class LinkViewHolder(
        view: View ,
        val txt_link: TextView = view.findViewById<TextView>(R.id.link)
    ) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LinkViewHolder(LayoutInflater.from(context).inflate(R.layout.item_link , parent , false))

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) {
        holder.txt_link.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
package com.example.drawermenu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.R

/*

@created in 31/12/2021 - 1:04 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class TimeAdapter (
    val context: Context
): RecyclerView.Adapter<TimeAdapter.TimeViewHolder>() {

    var data = mutableListOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class TimeViewHolder(
        view: View ,
        val txt_time: TextView = view.findViewById(R.id.txt_time) ,
    ) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
         TimeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_time, parent, false)
        )

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        val item = data[position]
        holder.apply {
            txt_time.text  = item
        }
    }

    override fun getItemCount() = data.size

}
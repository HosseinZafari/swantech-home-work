package com.example.drawermenu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.R
import java.util.zip.Inflater

/*

@created in 31/12/2021 - 1:04 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class EngineAdapter (
    val context: Context ,
    val onClickEvent: (String) -> Unit
): RecyclerView.Adapter<EngineAdapter.EngineViewHolder>() {

    var data = mutableListOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class EngineViewHolder(
        val view: View ,
        val txt_engine: TextView = view.findViewById(R.id.txt_engine) ,
    ) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EngineViewHolder(LayoutInflater.from(context).inflate(R.layout.item_engine , parent , false))

    override fun onBindViewHolder(holder: EngineViewHolder, position: Int) {
        val item = data[position]
        holder.apply {
            txt_engine.text  = item
            view.setOnClickListener {
                onClickEvent(item)
            }
        }
    }

    override fun getItemCount() = data.size

}
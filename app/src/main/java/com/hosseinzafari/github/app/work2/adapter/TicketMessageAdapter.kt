package com.hosseinzafari.github.app.work2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hosseinzafari.github.app.work2.R
import com.hosseinzafari.github.app.work2.model.TicketMessageModel

/*

@created in 18/12/2021 - 4:13 PM
@project Work2
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class TicketMessageAdapter(
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ADMIN = 0
        const val VIEW_TYPE_USER  = 1
    }

    var data: MutableList<TicketMessageModel> = mutableListOf()
        set (value)  {
            field.addAll(value)
            notifyDataSetChanged()
        }


    class TicketMessageAdminViewHolder (
        view: View ,
        val txt_ticket_admin : TextView = view.findViewById(R.id.txt_ticket_admin)
    ) :  RecyclerView.ViewHolder(view)

    class TicketMessageUserViewHolder (
        view: View ,
        val txt_ticket_user : TextView = view.findViewById(R.id.txt_ticket_user)
    ) :  RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            VIEW_TYPE_USER -> {
                TicketMessageUserViewHolder(inflater.inflate(R.layout.item_rv_ticket_user_msg , parent , false))
            }
            else -> {
                TicketMessageAdminViewHolder(inflater.inflate(R.layout.item_rv_ticket_admin_msg , parent , false))
            }
        }
    }

    override fun getItemViewType(position: Int) = if(position == 0) {
        VIEW_TYPE_ADMIN
    } else {
        VIEW_TYPE_USER
    }

    override fun onBindViewHolder(holder:  RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is TicketMessageUserViewHolder -> {
                val dataItem = data[position]
                holder.txt_ticket_user.text = dataItem.msg
            }
            is TicketMessageAdminViewHolder -> {
                val dataItem = data[position]
                holder.txt_ticket_admin.text = dataItem.msg
            }
        }

    }

    override fun getItemCount() = data.size
}
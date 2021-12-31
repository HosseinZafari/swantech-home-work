package com.hosseinzafari.github.app.work2.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hosseinzafari.github.app.work2.R
import com.hosseinzafari.github.app.work2.model.ActiveModel
import com.hosseinzafari.github.app.work2.model.StepModel

/*

@created in 14/12/2021 - 5:39 PM
@project Work2
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class ActiveLessonAdapter(
    val context: Context
) : RecyclerView.Adapter<ActiveLessonAdapter.ActiveLessonViewHolder>() {

    var data: List<ActiveModel> = emptyList()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    class ActiveLessonViewHolder (
        view : View,
        val txt_title_active_lesson: TextView  = view.findViewById(R.id.txt_title_active_lesson),
        val txt_number_active_lesson: TextView  = view.findViewById(R.id.txt_number_active_lesson),
    ) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ActiveLessonViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_rv_active_lesson, parent, false)
        )

    override fun onBindViewHolder(holder: ActiveLessonViewHolder, position: Int) {
        val modelItem = data[position]
        Log.i("test" , modelItem.toString())
        holder.txt_title_active_lesson.text = modelItem.message
        holder.txt_number_active_lesson.text = modelItem.number.toString()
    }

    override fun getItemCount() = data.size
}
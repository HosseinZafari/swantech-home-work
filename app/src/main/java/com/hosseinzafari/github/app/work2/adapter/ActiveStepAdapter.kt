package com.hosseinzafari.github.app.work2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hosseinzafari.github.app.work2.R
import com.hosseinzafari.github.app.work2.model.StepModel

/*

@created in 14/12/2021 - 5:39 PM
@project Work2
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class ActiveStepAdapter(
    val context: Context
) : RecyclerView.Adapter<ActiveStepAdapter.ActiveStepViewHolder>() {

    var stepData: List<StepModel> = emptyList()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    class ActiveStepViewHolder (
        view : View,
        val txt_step_item_active: TextView  = view.findViewById(R.id.txt_step_item_active)
    ) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ActiveStepViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_rv_active_step, parent, false)
    )

    override fun onBindViewHolder(holder: ActiveStepViewHolder, position: Int) {
        holder.txt_step_item_active.text = stepData[position].step.toString()
    }

    override fun getItemCount() = stepData.size
}
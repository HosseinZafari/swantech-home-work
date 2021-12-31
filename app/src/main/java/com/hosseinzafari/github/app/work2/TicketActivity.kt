package com.hosseinzafari.github.app.work2

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.hosseinzafari.github.app.work2.adapter.TicketMessageAdapter
import com.hosseinzafari.github.app.work2.model.TicketMessageModel

/*

@created in 19/12/2021 - 10:08 AM
@project Work2
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class TicketActivity : AppCompatActivity() {
    private val adapter = TicketMessageAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        setupViews()
        populateData(getData())
    }

    private fun setupViews() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_ticket)
        val edt_send_msg = findViewById<EditText>(R.id.edt_msg)
        val img_send_msg = findViewById<ImageButton>(R.id.img_send)
        recyclerView.adapter = adapter

        img_send_msg.setOnClickListener {
            if(edt_send_msg.text.isBlank())
                return@setOnClickListener

            populateData(listOf(TicketMessageModel(edt_send_msg.text.toString())))
            edt_send_msg.text = Editable.Factory.getInstance().newEditable("")
        }

    }

    private fun populateData(data: List<TicketMessageModel>) {
        adapter.data = data.toMutableList()
    }

    private fun getData() = listOf(
       TicketMessageModel("سلام ، به تیکت اپلیکیشن ما خوش آمدید شما میتوانید در صورت هر گونه مشکل در برنامه به در اینجا پیغام دهید.")
    )
}
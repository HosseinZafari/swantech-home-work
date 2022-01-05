package com.example.drawermenu.fragment

import android.content.ClipboardManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.drawermenu.MainActivity
import com.example.drawermenu.R

/*

@created in 30/12/2021 - 9:22 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class VideoFragment : Fragment() {

    private lateinit var clipboardManager: ClipboardManager
    private lateinit var edt_url: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        setupViews(view)
    }

    override fun onResume() {
        if(clipboardManager.primaryClip?.itemCount!! > 0) {
            val urlCopied = clipboardManager.primaryClip?.getItemAt(0)?.text
            edt_url.text = Editable.Factory.getInstance().newEditable(urlCopied)
        }
        super.onResume()
    }

    private fun setupViews(view: View) {
        val mediaController = MediaController(requireContext())
        val video_view = view.findViewById<VideoView>(R.id.video_main)
        val btn_play   = view.findViewById<Button>(R.id.btn_play)
        edt_url    = view.findViewById<EditText>(R.id.edt_url_video)


        video_view.setMediaController(mediaController)


        btn_play.setOnClickListener {
            val link = edt_url.text.toString()
            video_view.setVideoURI(Uri.parse(link))
            video_view.start()
            MainActivity.videoList.add(link)
        }

    }

}
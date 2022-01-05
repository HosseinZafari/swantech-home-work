package com.example.drawermenu.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.drawermenu.R

/*

@created in 30/12/2021 - 9:22 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class WebFragment(
    val onLongClick: (String) -> Unit
) : Fragment() {

    companion object {
        const val url = "https://google.com/"
    }

    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web, container, false)
    }


    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = view.findViewById(R.id.webview_main)
        webView.apply {
            loadUrl(WebFragment.url)
            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            webViewClient = WebViewClient()
            setOnLongClickListener {
                val result = (it as  WebView).hitTestResult
                result.extra?.let { link ->
                    onLongClick(link)
                    Log.i("Test" , "" + link)
                }
                true
            }
        }


    }



}
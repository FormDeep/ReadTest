package com.toporead.readtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText


class WebFragment : Fragment() {
    private lateinit var webView: WebView
    private lateinit var editText: EditText
    private lateinit var button: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        editText =view.findViewById(R.id.webedit)
        button =view.findViewById(R.id.webbtn)
        button.setOnClickListener {
            var web :String =editText.text.toString()
            editText.setText("")
            webView.loadUrl("https://$web")
        }






    }


    fun loadUri(webSite:String){
        webView.loadUrl(webSite)
    }

}
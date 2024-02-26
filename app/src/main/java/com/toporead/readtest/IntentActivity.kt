package com.toporead.readtest

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IntentActivity : AppCompatActivity() {

    private lateinit var textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        val intent = intent
        val action = intent.action
        val data = intent.data
        textview = findViewById(R.id.Uri_text)

        if (action == Intent.ACTION_VIEW && data != null) {
            // 提取链接
            val url = data.toString()

            showUrl(url)

        }


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        // 处理新的Intent
        val action = intent?.action
        val data = intent?.data

        if (action == Intent.ACTION_VIEW && data != null) {
            val url = data.toString()
            showUrl(url)
        }

    }

    fun showUrl(url: String) {
        textview.setText(url)
    }


}
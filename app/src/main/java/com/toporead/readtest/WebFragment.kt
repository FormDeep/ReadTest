package com.toporead.readtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.EditText
import androidx.appcompat.app.AlertDialog


class WebFragment : Fragment() {
    private lateinit var webView: WebView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = requireContext()
        var inputText: String =""
        val builder = AlertDialog.Builder(context)
        builder.setTitle("输入框标题") // 设置对话框标题

// 创建一个EditText实例作为输入框
        val input = EditText(context).apply {
            hint = "请输入内容" // 设置输入框的提示文本
        }

// 将EditText设置为对话框内容
        builder.setView(input)

// 设置对话框的“确定”按钮及其点击事件
        builder.setPositiveButton("确定") { dialog, which ->
            // 当点击“确定”按钮时获取输入框中的文本
            inputText = input.text.toString()
        }


        builder.setNegativeButton("取消") { dialog, which ->

        }

        builder.show()

        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://$inputText")

    }

    companion object {
        @JvmStatic
        fun newInstance() = WebFragment()
    }

}
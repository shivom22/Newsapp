package com.example.vvviewww

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val webview = findViewById<WebView>(R.id.webView)
        val progresbar = findViewById<ProgressBar>(R.id.progressBar2)
        val url = intent.getStringExtra("url")
        if (url!=null){
            webview.settings.javaScriptEnabled = true
            webview.settings.userAgentString = "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
            webview.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progresbar.visibility = View.GONE
                    webview.visibility = View.VISIBLE
                }
            }
            webview.loadUrl(url)
        }
    }
}
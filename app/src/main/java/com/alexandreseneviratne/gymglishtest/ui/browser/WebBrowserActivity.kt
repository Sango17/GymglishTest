package com.alexandreseneviratne.gymglishtest.ui.browser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import com.alexandreseneviratne.gymglishtest.R
import kotlinx.android.synthetic.main.activity_web_browser.*

class WebBrowserActivity : AppCompatActivity() {
    companion object {
        const val WEBSITE_TITLE: String = "website_title"
        const val WEBSITE_URL_ADDRESS: String = "website_url_address"
    }

    private lateinit var webView: WebView
    private val webViewClient: WebViewClient = object: WebViewClient(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_browser)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val selectedWebsiteTitle = intent.getStringExtra(WEBSITE_TITLE)
        val selectedWebsiteUrlAddress = intent.getStringExtra(WEBSITE_URL_ADDRESS)

        supportActionBar?.title = selectedWebsiteTitle
        supportActionBar?.subtitle = selectedWebsiteUrlAddress

        webView = findViewById(R.id.web_browser_web_view)
        webView.webViewClient = webViewClient

        val webViewSettings = webView.settings
        webViewSettings.javaScriptEnabled = true

        webView.loadUrl(selectedWebsiteUrlAddress)

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onSupportNavigateUp(): Boolean {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
        return true
    }
}

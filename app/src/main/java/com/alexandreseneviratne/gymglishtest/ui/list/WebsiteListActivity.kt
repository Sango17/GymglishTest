package com.alexandreseneviratne.gymglishtest.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexandreseneviratne.gymglishtest.R
import com.alexandreseneviratne.gymglishtest.ui.browser.WebBrowserActivity
import com.alexandreseneviratne.gymglishtest.ui.login.LoginActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_website_list.*

class WebsiteListActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: WebListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website_list)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Website List"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(this).get(WebListViewModel::class.java)

        viewModel.getWebsiteListAdapter(this)

        web_list_recycler_view.layoutManager = LinearLayoutManager(this)
        web_list_recycler_view.adapter = viewModel.getAdapter()

        Snackbar.make(web_list_layout, "You're logged !", Snackbar.LENGTH_SHORT).show()
    }

    override fun onClick(v: View) {
        if (v.tag != null) {
            val index: Int = v.tag as Int
            val website = viewModel.getWebsiteList()[index]

            val intent = Intent(this, WebBrowserActivity::class.java)
            intent.putExtra(WebBrowserActivity.WEBSITE_TITLE, website.title)
                .putExtra(WebBrowserActivity.WEBSITE_URL_ADDRESS, website.urlAddress)

            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}

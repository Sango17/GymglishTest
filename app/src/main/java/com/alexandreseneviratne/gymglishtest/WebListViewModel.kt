package com.alexandreseneviratne.gymglishtest

import android.view.View
import androidx.lifecycle.ViewModel
import com.alexandreseneviratne.gymglishtest.Adapter.WebsiteListAdapter
import com.alexandreseneviratne.gymglishtest.data.Website

/**
 * Created by Alexandre SENEVIRATNE on 6/18/2019.
 */
class WebListViewModel: ViewModel() {
    private lateinit var websiteList: MutableList<Website>
    private lateinit var adapter: WebsiteListAdapter

    fun getAdapter(): WebsiteListAdapter = adapter

    fun getWebsiteList(): MutableList<Website> = websiteList

    fun getWebsiteListAdapter(itemClickListener: View.OnClickListener) {
        websiteList = mutableListOf()

        websiteList.add(Website("Hello", "https://www.gymglish.com/fr"))
        websiteList.add(Website("Hello", "https://www.frantastique.com"))
        websiteList.add(Website("Hello", "https://www.vatefaireconjuguer.com/"))

        adapter = WebsiteListAdapter(websiteList, itemClickListener)
    }
}
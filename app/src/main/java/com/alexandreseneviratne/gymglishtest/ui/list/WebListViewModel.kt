package com.alexandreseneviratne.gymglishtest.ui.list

import android.view.View
import androidx.lifecycle.ViewModel
import com.alexandreseneviratne.gymglishtest.adapter.WebsiteListAdapter
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

        websiteList.add(Website("Gymglish", "https://www.gymglish.com/fr"))
        websiteList.add(Website("Frantastique", "https://www.frantastique.com"))
        websiteList.add(Website("Vatefaireconjuguer", "https://www.vatefaireconjuguer.com/"))
        websiteList.add(Website("Rich Morning", "https://www.richmorning.com/fr"))

        adapter = WebsiteListAdapter(websiteList, itemClickListener)
    }
}
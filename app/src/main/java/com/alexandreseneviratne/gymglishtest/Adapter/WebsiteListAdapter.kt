package com.alexandreseneviratne.gymglishtest.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.alexandreseneviratne.gymglishtest.R
import com.alexandreseneviratne.gymglishtest.data.Website

/**
 * Created by Alexandre SENEVIRATNE on 6/18/2019.
 */
class WebsiteListAdapter(
    private val websiteList: MutableList<Website>,
    private val itemOnClickListener: View.OnClickListener
): RecyclerView.Adapter<WebsiteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.list_item_website, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return websiteList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val website = websiteList[position]

        holder.title.text = website.title

        holder.card.tag = position
        holder.card.setOnClickListener(itemOnClickListener)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.web_list_item_title)
        val card: CardView = itemView.findViewById(R.id.web_list_card_view)
    }
}
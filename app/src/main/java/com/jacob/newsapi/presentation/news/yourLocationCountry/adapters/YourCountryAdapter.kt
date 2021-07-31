package com.jacob.newsapi.presentation.news.yourLocationCountry.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextClock
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.jacob.newsapi.R
import com.jacob.newsapi.presentation.news.yourLocationCountry.model.DataYourCountry
import com.jacob.newsapi.presentation.news.yourLocationCountry.view.YourLocationCountry

class YourCountryAdapter(
    private val yourCountryList: List<DataYourCountry>,
    yourLocationCountry: YourLocationCountry
) : RecyclerView.Adapter<YourCountryAdapter.YourCountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourCountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_your_country,parent,false)
        return YourCountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: YourCountryViewHolder, position: Int) {
        val country = yourCountryList[position]
        country.img?.let { holder.image?.setImageResource(it) }
        holder.name.text = country.name
        holder.date.text = country.date
    }

    override fun getItemCount() = yourCountryList.size

    class YourCountryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<AppCompatImageView>(R.id.imgYourCountry)
        val name = view.findViewById<TextView>(R.id.txtName)
        val date = view.findViewById<TextView>(R.id.txtDate)
    }
}
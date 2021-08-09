package com.jacob.newsapi.presentation.news.yourLocationCountry.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jacob.newsapi.R
import com.jacob.newsapi.data.network.models.Article
import com.jacob.newsapi.data.utils.Configurations
import com.jacob.newsapi.presentation.core.callBack.OnItemClickListener

class YourCountryAdapter(
    private val yourCountryList: List<Article>,
    private val onItemClickListener: OnItemClickListener<Article>,
) : RecyclerView.Adapter<YourCountryAdapter.YourCountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourCountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_your_country,parent,false)
        return YourCountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: YourCountryViewHolder, position: Int) {
        val country = yourCountryList[position]
        //country.img?.let { holder.image?.setImageResource(it) }
        Glide
            .with(holder.view.context)
            .load(country.urlToImage)
            .into(holder.image)
        holder.name.text = country.author
        holder.date.text = country.title
        holder.container.setOnClickListener{
            onItemClickListener.onItemClic(country)
        }
    }

    override fun getItemCount() = yourCountryList.size

    class YourCountryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<AppCompatImageView>(R.id.imgYourCountry)
        val name = view.findViewById<TextView>(R.id.txtName)
        val date = view.findViewById<TextView>(R.id.txtDate)
        val container = view.findViewById<ConstraintLayout>(R.id.container)
    }
}
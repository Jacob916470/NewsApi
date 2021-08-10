package com.jacob.newsapi.presentation.international.adapters

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
import com.jacob.newsapi.presentation.core.callBack.OnItemClickListener

class InternationalAdapter(
    private val internationalList: List<Article>,
    private val onItemClickListener: OnItemClickListener<Article>
): RecyclerView.Adapter<InternationalAdapter.InternationalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InternationalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_international,parent,false)
        return InternationalViewHolder(view)
    }

    override fun onBindViewHolder(holder: InternationalViewHolder, position: Int) {
        val international = internationalList[position]
        Glide
            .with(holder.view.context)
            .load(international.urlToImage)
            .into(holder.iImage)
        //international.iImg?.let { holder.iImage?.setImageResource(it) }
        holder.iName.text = international.title
        holder.iDate.text = international.author
        holder.iContainer.setOnClickListener {
            onItemClickListener.onItemClic(international)
        }
    }

    override fun getItemCount() = internationalList.size

    class InternationalViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val iImage = view.findViewById<AppCompatImageView>(R.id.iImg)
        val iName = view.findViewById<TextView>(R.id.txtInternationalName)
        val iDate = view.findViewById<TextView>(R.id.txtInternationalDate)
        val iContainer = view.findViewById<ConstraintLayout>(R.id.iContainer)

    }
}
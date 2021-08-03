package com.jacob.newsapi.presentation.news.local.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.jacob.newsapi.R
import com.jacob.newsapi.presentation.core.callBack.OnItemClickListener
import com.jacob.newsapi.presentation.news.local.model.DataLocal

class LocalAdapter(
    private val localList: List<DataLocal>,
    private val onItemClickListener: OnItemClickListener<DataLocal>
) : RecyclerView.Adapter<LocalAdapter.LocalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_local,parent,false)
        return LocalViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocalViewHolder, position: Int) {
        val local = localList[position]
        local.lImg?.let { holder.lImage?.setImageResource(it) }
        holder.lName.text = local.lNmae
        holder.lDate.text = local.lDate
        holder.lContainer.setOnClickListener {
            onItemClickListener.onItemClic(local)
        }
    }

    override fun getItemCount() = localList.size

    class LocalViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val lImage = view.findViewById<AppCompatImageView>(R.id.lImg)
        val lName = view.findViewById<TextView>(R.id.txtLocalName)
        val lDate = view.findViewById<TextView>(R.id.txtLocalDate)
        val lContainer = view.findViewById<ConstraintLayout>(R.id.lContainer)


    }
}
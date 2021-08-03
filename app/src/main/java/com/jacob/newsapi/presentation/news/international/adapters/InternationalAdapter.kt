package com.jacob.newsapi.presentation.news.international.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.jacob.newsapi.R
import com.jacob.newsapi.presentation.core.callBack.OnItemClickListener
import com.jacob.newsapi.presentation.news.international.model.DataInternational

class InternationalAdapter(
    private val internationalList: List<DataInternational>,
    private val onItemClickListener: OnItemClickListener<DataInternational>
): RecyclerView.Adapter<InternationalAdapter.InternationalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InternationalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_international,parent,false)
        return InternationalViewHolder(view)
    }

    override fun onBindViewHolder(holder: InternationalViewHolder, position: Int) {
        val international = internationalList[position]
        international.iImg?.let { holder.iImage?.setImageResource(it) }
        holder.iName.text = international.iName
        holder.iDate.text = international.iDate
        holder.iContainer.setOnClickListener {
            onItemClickListener.onItemClic(international)
        }
    }

    override fun getItemCount() = internationalList.size

    class InternationalViewHolder(view: View): RecyclerView.ViewHolder(view){
        val iImage = view.findViewById<AppCompatImageView>(R.id.iImg)
        val iName = view.findViewById<TextView>(R.id.txtInternationalName)
        val iDate = view.findViewById<TextView>(R.id.txtInternationalDate)
        val iContainer = view.findViewById<ConstraintLayout>(R.id.iContainer)

    }
}
package com.jacob.newsapi.presentation.news.local.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jacob.newsapi.R
import com.jacob.newsapi.databinding.FragmentLocalBinding
import com.jacob.newsapi.presentation.core.callBack.OnItemClickListener
import com.jacob.newsapi.presentation.news.local.adapters.LocalAdapter
import com.jacob.newsapi.presentation.news.local.model.DataLocal
import com.jacob.newsapi.presentation.news.local.viewModel.LocalViewModel

class LocalFragment:Fragment(), OnItemClickListener<DataLocal> {

    private var fragmentLocalBinding: FragmentLocalBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLocalBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_local,
            container,
            false
        )
        fragmentLocalBinding?.localViewModel =
            ViewModelProvider(
                this
            ).get(LocalViewModel::class.java)

        return fragmentLocalBinding?.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLocalBinding?.localViewModel?.localL?.observe(
            viewLifecycleOwner,{local ->
                if (local.isNotEmpty()){
                    fragmentLocalBinding?.rvLocal?.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = LocalAdapter(local,this@LocalFragment)
                    }
                }
            }
        )
    }

    override fun onItemClic(item: DataLocal, type: String?) {

    }
}
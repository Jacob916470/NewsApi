package com.jacob.newsapi.presentation.local.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jacob.newsapi.R
import com.jacob.newsapi.data.network.models.Article
import com.jacob.newsapi.data.network.repositories.ApiNewsNetworkRepository
import com.jacob.newsapi.databinding.FragmentLocalBinding
import com.jacob.newsapi.domain.useCases.GetNewsApiUseCase
import com.jacob.newsapi.presentation.core.callBack.OnItemClickListener
import com.jacob.newsapi.presentation.local.adapters.LocalAdapter
import com.jacob.newsapi.presentation.local.viewModel.LocalViewModel
import com.jacob.newsapi.presentation.local.viewModel.LocalViewModelFactory

class LocalFragment:Fragment(), OnItemClickListener<Article> {

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
                this,
                LocalViewModelFactory(
                    GetNewsApiUseCase(ApiNewsNetworkRepository())
                )
            ).get(LocalViewModel::class.java)

        return fragmentLocalBinding?.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLocalBinding?.localViewModel?.newsApiResponseMDL?.observe(
            viewLifecycleOwner,{local ->
                if (local.articles.isNotEmpty()){
                    fragmentLocalBinding?.rvLocal?.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = LocalAdapter(local.articles,this@LocalFragment)
                    }
                }
            }
        )
    }

    override fun onItemClic(item: Article, type: String?) {

    }
}
package com.jacob.newsapi.presentation.news.yourLocationCountry.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jacob.newsapi.R
import com.jacob.newsapi.databinding.FragmentYourLocationBinding
import com.jacob.newsapi.presentation.core.callBack.OnItemClickListener
import com.jacob.newsapi.presentation.news.yourLocationCountry.adapters.YourCountryAdapter
import com.jacob.newsapi.presentation.news.yourLocationCountry.model.DataYourCountry
import com.jacob.newsapi.presentation.news.yourLocationCountry.viewModel.YourLocationViewModel

class YourLocationCountry: Fragment(), OnItemClickListener<DataYourCountry> {

    private var fragmentYourLocationCountryBinding: FragmentYourLocationBinding? = null

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
        fragmentYourLocationCountryBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_your_location,
            container,
            false
        )
        fragmentYourLocationCountryBinding?.yourLocationViewModel =
            ViewModelProvider(
                this
            ).get(YourLocationViewModel::class.java)

        return fragmentYourLocationCountryBinding?.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentYourLocationCountryBinding?.yourLocationViewModel?.countryL?.observe(
            viewLifecycleOwner,{country ->
                if (country.isNotEmpty()){
                    fragmentYourLocationCountryBinding?.rvCountry?.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = YourCountryAdapter(country,this@YourLocationCountry)
                    }
                }
            }
        )
    }

    override fun onItemClic(item: DataYourCountry, type: String?) {

    }
}
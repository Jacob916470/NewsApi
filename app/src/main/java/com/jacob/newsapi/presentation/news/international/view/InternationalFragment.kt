package com.jacob.newsapi.presentation.news.international.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jacob.newsapi.R
import com.jacob.newsapi.databinding.FragmentInternationalBinding
import com.jacob.newsapi.presentation.news.international.viewModel.InternationalViewModel

class InternationalFragment:Fragment() {

    private var fragmentInternationalBinding: FragmentInternationalBinding? = null

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
        fragmentInternationalBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_international,
            container,
            false
        )
        fragmentInternationalBinding?.internationalViewModel =
            ViewModelProvider(
                this
            ).get(InternationalViewModel::class.java)

        return fragmentInternationalBinding?.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
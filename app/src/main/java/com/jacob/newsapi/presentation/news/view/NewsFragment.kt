package com.jacob.newsapi.presentation.news.view

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.jacob.newsapi.R
import com.jacob.newsapi.databinding.FragmentNewsBinding
import com.jacob.newsapi.presentation.news.adapters.ViewPagerAdapter
import com.jacob.newsapi.presentation.international.view.InternationalFragment
import com.jacob.newsapi.presentation.local.view.LocalFragment
import com.jacob.newsapi.presentation.news.viewModel.NewsViewModel
import com.jacob.newsapi.presentation.yourLocationCountry.view.YourLocationCountry

class NewsFragment:Fragment() {

    private var fragmentNewsBinding: FragmentNewsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentNewsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_news,
            container,
            false
        )
            fragmentNewsBinding?.newsViewModel =
            ViewModelProvider(
                this
            ).get(NewsViewModel::class.java)

        setUpTaps()

        return fragmentNewsBinding?.root

       /* val root = inflater.inflate(R.layout.fragment_news,container,false)
        val viewPager = root.findViewById<ViewPager>(R.id.viewPager)
        val tabs = root.findViewById<TabLayout>(R.id.tabs)
        val adapter = ViewPagerAdapter(supporrtFragmentManager = childFragmentManager)
        adapter.addFragment(YourLocationCountry(), resources.getString(R.string.your_country))
        adapter.addFragment(InternationalFragment(), "International")
        adapter.addFragment(LocalFragment(), "Local")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
        return root*/
    }

    private fun setUpTaps() {
        val adapter = ViewPagerAdapter(supporrtFragmentManager = childFragmentManager)
        adapter.addFragment(YourLocationCountry(), resources.getString(R.string.your_country))
        adapter.addFragment(InternationalFragment(), "International")
        adapter.addFragment(LocalFragment(), "Local")
        fragmentNewsBinding?.viewPager?.adapter = adapter
        fragmentNewsBinding?.tabs?.setupWithViewPager(fragmentNewsBinding?.viewPager)

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_view, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.file -> {
                findNavController().navigateUp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
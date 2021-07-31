package com.jacob.newsapi.presentation.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.jacob.newsapi.R
import com.jacob.newsapi.presentation.news.international.view.InternationalFragment
import com.jacob.newsapi.presentation.news.local.view.LocalFragment
import com.jacob.newsapi.presentation.news.adapters.ViewPagerAdapter
import com.jacob.newsapi.presentation.news.yourLocationCountry.view.YourLocationCountry

class NewsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        setUpTabs()
    }

    private fun setUpTabs() {
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabs = findViewById<TabLayout>(R.id.tabs)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(YourLocationCountry(),"Your Country")
        adapter.addFragment(InternationalFragment(),"International")
        adapter.addFragment(LocalFragment(),"Local")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)


    }
}
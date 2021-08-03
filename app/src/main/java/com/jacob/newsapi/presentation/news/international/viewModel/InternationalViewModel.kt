package com.jacob.newsapi.presentation.news.international.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jacob.newsapi.R
import com.jacob.newsapi.presentation.news.international.model.DataInternational

class InternationalViewModel: ViewModel() {

    val internationalL = MutableLiveData<List<DataInternational>>()

    init {
        getInternationalWS()
    }

    fun getInternationalWS(){
        val internationalVWM = listOf(
            DataInternational(R.drawable.hinsense, "dsfsdf", "asfsfs"),
            DataInternational(R.drawable.hinsense, "dsfsdf", "asfsfs"),
            DataInternational(R.drawable.hinsense, "dsfsdf", "asfsfs"),
            DataInternational(R.drawable.hinsense, "dsfsdf", "asfsfs"),
            DataInternational(R.drawable.hinsense, "dsfsdf", "asfsfs"),
        )
        internationalL.postValue(internationalVWM)
    }
}
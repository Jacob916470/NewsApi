package com.jacob.newsapi.presentation.news.yourLocationCountry.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jacob.newsapi.R
import com.jacob.newsapi.presentation.news.yourLocationCountry.model.DataYourCountry

class YourLocationViewModel:ViewModel() {
    val countryL = MutableLiveData<List<DataYourCountry>>()

    init {
        getCountryWS()
    }

    private fun getCountryWS() {
        val countryVWM = listOf(
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997"),
            DataYourCountry(R.drawable.horno_de_microondas,"mexico","31/07/1997")
        )
        countryL.postValue(countryVWM)
    }
}
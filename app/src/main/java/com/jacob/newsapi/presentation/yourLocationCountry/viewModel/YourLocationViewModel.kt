package com.jacob.newsapi.presentation.yourLocationCountry.viewModel

import androidx.lifecycle.MutableLiveData
import com.jacob.newsapi.data.network.models.NewsApiResponse
import com.jacob.newsapi.data.utils.Configurations
import com.jacob.newsapi.domain.useCases.GetNewsApiUseCase
import com.jacob.newsapi.presentation.core.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class YourLocationViewModel(
    private val getNewsApiUseCase: GetNewsApiUseCase
):BaseViewModel() {

    var newsApiResponseMLD = MutableLiveData<NewsApiResponse>()
    var newsApiResponse: NewsApiResponse? = null

    init {
        getCountryWS()
        getNewsApi()
    }

    private fun getNewsApi() {
        job = CoroutineScope(Dispatchers.IO).launch {
            newsApiResponse = getNewsApiUseCase.invoke(
                apiKey = Configurations.NEWS_API_KEY
            ).body()
            withContext(Dispatchers.Main){
                newsApiResponse?.let {
                    newsApiResponseMLD.postValue(
                        it
                    )
                }
            }
        }
    }

    private fun getCountryWS() {

    }
}
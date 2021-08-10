package com.jacob.newsapi.presentation.international.viewModel

import androidx.lifecycle.MutableLiveData
import com.jacob.newsapi.data.network.models.NewsApiResponse
import com.jacob.newsapi.data.utils.Configurations
import com.jacob.newsapi.domain.useCases.GetNewsApiUseCase
import com.jacob.newsapi.presentation.core.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InternationalViewModel(
    private val getNewsApiUseCase: GetNewsApiUseCase
):BaseViewModel() {

    var newsApiResponseMLD = MutableLiveData<NewsApiResponse>()
    var newsApiResponse: NewsApiResponse? = null

    init {
        getInternationalWS()
    }

    fun getInternationalWS(){
        job = CoroutineScope(Dispatchers.IO).launch {
            newsApiResponse = getNewsApiUseCase.invokeTwo(
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
}
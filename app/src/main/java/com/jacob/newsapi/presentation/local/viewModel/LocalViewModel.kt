package com.jacob.newsapi.presentation.local.viewModel

import androidx.lifecycle.MutableLiveData
import com.jacob.newsapi.data.network.models.NewsApiResponse
import com.jacob.newsapi.data.utils.Configurations
import com.jacob.newsapi.domain.useCases.GetNewsApiUseCase
import com.jacob.newsapi.presentation.core.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LocalViewModel(
    private val getNewsApiUseCase: GetNewsApiUseCase
):BaseViewModel() {

    var newsApiResponseMDL = MutableLiveData<NewsApiResponse>()
    var newsApiResponse: NewsApiResponse? = null

    init {
        getLocalWS()
    }

    private fun getLocalWS() {
        job = CoroutineScope(Dispatchers.IO).launch {
            newsApiResponse = getNewsApiUseCase.invokeThree(
                apiKey = Configurations.NEWS_API_KEY
            ).body()
            withContext(Dispatchers.Main){
                newsApiResponse?.let {
                    newsApiResponseMDL.postValue(
                        it
                    )
                }
            }
        }
    }
}
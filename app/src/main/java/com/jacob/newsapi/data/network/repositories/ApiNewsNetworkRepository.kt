package com.jacob.newsapi.data.network.repositories

import com.jacob.newsapi.data.network.NetworkModule
import com.jacob.newsapi.data.network.models.NewsApiResponse
import com.jacob.newsapi.data.network.services.NewsApiService
import com.jacob.newsapi.data.utils.Configurations
import com.jacob.newsapi.domain.repositories.GetApiRepository
import retrofit2.Response

class ApiNewsNetworkRepository():GetApiRepository {

    private val retrofirInstance =
        NetworkModule().provideRetofit(baseURL = Configurations().getBaseURL())

    override suspend fun getNewsApiRepository(
        apiKey: String
    ): Response<NewsApiResponse> {
        return NetworkModule().provideApi(
            retrofit = retrofirInstance,
            service = NewsApiService::class.java
        ).getApiNews(
            apiKey= apiKey
        )
    }

}
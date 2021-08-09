package com.jacob.newsapi.domain.repositories

import com.jacob.newsapi.data.network.models.NewsApiResponse
import retrofit2.Response

interface GetApiRepository {
    suspend fun getNewsApiRepository(
        apiKey: String
    ): Response<NewsApiResponse>

}
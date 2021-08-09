package com.jacob.newsapi.data.network.services

import com.jacob.newsapi.data.network.models.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    /** End point */
    @GET(value = "https://newsapi.org/v2/top-headlines?country=us")
    suspend fun getApiNews(
        @Query(value = "apikey")
        apiKey: String
    ): Response<NewsApiResponse>

}
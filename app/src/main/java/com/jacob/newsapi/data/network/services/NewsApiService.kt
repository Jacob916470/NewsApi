package com.jacob.newsapi.data.network.services

import com.jacob.newsapi.data.network.models.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    /** End point: es a quel que nos brinda la liga que nos provera de nuestra información
     *  que proviene de nuestro Json*/
    @GET(value = "https://newsapi.org/v2/top-headlines?country=us")
    suspend fun getApiNews(
        /** Se crea "suspend fun getApiNews"  la cual generaremmos una Query que obtendra un valir string "apikey"
         * y heredara de Response de tipo "<NewsApiResponse>"*/
        @Query(value = "apikey")

        /** Se crea variable "apiKey" de tipo Sting*/
        apiKey: String
    ): Response<NewsApiResponse>

}
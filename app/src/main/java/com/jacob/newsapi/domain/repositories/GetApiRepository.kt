package com.jacob.newsapi.domain.repositories

import com.jacob.newsapi.data.network.models.NewsApiResponse
import retrofit2.Response

interface GetApiRepository {

    /** Se crea suspend fun que obtendra nuestra apikey y heredara de Response y sera de tipo  "<NewsApiResponse>" */
    suspend fun     getNewsApiRepository(
        /** Se crea variable apikey de tipo string */
        apiKey: String
    ): Response<NewsApiResponse>

    /** Se crea suspend fun que obtendra nuestra apikey y heredara de Response y sera de tipo  "<NewsApiResponse>" */
    suspend fun getNewsApiRepositoryTwo(
        /** Se crea variable apikey de tipo string */
        apiKey: String
    ): Response<NewsApiResponse>

    suspend fun getNewsApiRepositoryThree(
        apiKey: String
    ): Response<NewsApiResponse>
}
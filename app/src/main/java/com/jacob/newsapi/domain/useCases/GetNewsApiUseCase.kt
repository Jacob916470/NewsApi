package com.jacob.newsapi.domain.useCases

import com.jacob.newsapi.data.network.models.NewsApiResponse
import com.jacob.newsapi.domain.repositories.GetApiRepository
import retrofit2.Response

class GetNewsApiUseCase(
    private val getApiRepository: GetApiRepository
) {
    suspend fun invoke(
        apiKey: String
    ): Response<NewsApiResponse>{
        return getApiRepository.getNewsApiRepository(
            apiKey = apiKey
        )
    }
}
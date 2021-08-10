package com.jacob.newsapi.domain.useCases

import com.jacob.newsapi.data.network.models.NewsApiResponse
import com.jacob.newsapi.domain.repositories.GetApiRepository
import retrofit2.Response

class GetNewsApiUseCase(
    /** Se crea variable privada "getApiRepository" de tipo "GetApiRepository" */
    private val getApiRepository: GetApiRepository
) {

    /** Se crea suspend fun " invoke" la cual sera heredara de Response con un tipo "NewsApiReponse" */
    suspend fun invoke(

        /** Se crea variable apiKey de tipo String*/
        apiKey: String
    ): Response<NewsApiResponse>{

        /** Retornamos nuestra variable getApiRepository junto con la función "getNewsApiRepository" */
        return getApiRepository.getNewsApiRepository(

            /** Mandamos a llamar nuestra variable "apiKey" que provine de nuestra función "getNewsApiRepository"
             * y la igualamos a nuestra variable "apiKey" que proviene de nuestra "suspend fun invoke" */
            apiKey = apiKey
        )
    }

    suspend fun invokeTwo(

        /** Se crea variable apiKey de tipo String*/
        apiKey: String
    ): Response<NewsApiResponse>{

        /** Retornamos nuestra variable getApiRepository junto con la función "getNewsApiRepository" */
        return getApiRepository.getNewsApiRepositoryTwo(
            /** Mandamos a llamar nuestra variable "apiKey" que provine de nuestra función "getNewsApiRepository"
             * y la igualamos a nuestra variable "apiKey" que proviene de nuestra "suspend fun invoke" */
            apiKey = apiKey
        )
    }

    suspend fun invokeThree(
        apiKey: String
    ):Response<NewsApiResponse>{
        return  getApiRepository.getNewsApiRepositoryThree(
            apiKey = apiKey
        )
    }

}
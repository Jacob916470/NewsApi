package com.jacob.newsapi.data.network.repositories

import com.jacob.newsapi.data.network.NetworkModule
import com.jacob.newsapi.data.network.models.NewsApiResponse
import com.jacob.newsapi.data.network.services.NewsApiService
import com.jacob.newsapi.data.utils.Configurations
import com.jacob.newsapi.domain.repositories.GetApiRepository
import retrofit2.Response

/** Heredamos de "GetApiRepository" que proviene de nuestro repository que se encuentra en nuestra package domain */
class ApiNewsNetworkRepository():GetApiRepository {

    /** creamos variable privada "retrofitInstance" que sera igualada a nuestra clase "NetworkModule" la cual
     * nos permitira acceder a nuestra función "provideRetofit" la cual mandaremos a traer a su costructor la variable
     * "baseURL" que sera igualada a nuestra clase "Configurations" que nos permitira acceder a nuestra función
     * "getBaseURL" la cual traera nuestra variable "baseURL" que contendra nuestra liga de nuestro servicio*/
    private val retrofitInstance =
        NetworkModule().provideRetofit(baseURL = Configurations().getBaseURL())

    /** Sobre escribimos nuestra función "getNewsApiRepository" que proviene de nuestra interface "GetApiRepository",
     * también heredaremos a la función de Response de tipo "<NewsApiResponse>"*/
    override suspend fun getNewsApiRepository(
        /** Se crea variable "apiKey" de tipo String */
        apiKey: String
    ): Response<NewsApiResponse> {
        /** Retornaremos nuestra clase "NetworkModule" la cual accede a nuestra función "provideApi".
         * En su constructor mandaremos a llamar la variables "retrofit" que sera igualada a la variable
         * "retofritInstance" y "Service" la cual sera igualada a nuestra interface "NewsApoService" que proviene
         * de nuestro package network/module */
        return NetworkModule().provideApi(
            retrofit = retrofitInstance,
            service = NewsApiService::class.java
        /** Accederemos a nuestra función "getApiNews" que proviene de nuestra interface "NewsApiService" y en
         * su constructor mandaremos a llamar a nuestra variable "apiKey" que proviene de la misma interface
         * y la igualaremos a "apiKey" que proviene de nuestra "suspend fun getNewsApiRepository"
         * la cual sobre escribimos */
        ).getApiNews(
            apiKey = apiKey
        )
    }

}
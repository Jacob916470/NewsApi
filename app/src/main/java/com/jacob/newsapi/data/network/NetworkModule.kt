package com.jacob.newsapi.data.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkModule {

    /** Se crea un companion objet el cual contendra un const val "TAG_NETWORK" que será igualada a un String "WS"*/
    companion object{
        const val TAG_NETWORK = "WS"
    }

    /** Se crea función "provideRetrofit" que contentra una variable "baseURL" de tipo String y heredara de Retrofit */
    fun provideRetofit(baseURL: String): Retrofit{
        /** Nos retornara nuestro servicio creado por medio de Retrofit*/
        return Retrofit.Builder()
            .baseUrl(baseURL)/** Asignamos nuestra variable "baseURL" de nuestra función*/
            .client(createClient())/** Asignamos nuestra función creada "createClient"*/
            .addConverterFactory(GsonConverterFactory.create())
            .build()/** Construimos nuestro servicio*/
    }

    /** Creamos función createCliente para poder construir nuestro servicio y heredara de OkHttpClient*/
    private fun createClient(): OkHttpClient {
        /** */
        val okHttpClient = OkHttpClient.Builder()
        /**  */
        okHttpClient.addInterceptor(
            HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger{
                override fun log(message: String) {
                    Log.i(TAG_NETWORK,message)
                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        /** Asignamos el tiempo de conección/lectura/escritura */
        okHttpClient.connectTimeout(100,TimeUnit.SECONDS)
        okHttpClient.readTimeout(100,TimeUnit.SECONDS)
        okHttpClient.writeTimeout(100,TimeUnit.SECONDS)
        return okHttpClient.build()
    }

    /**  */
    fun <T> provideApi(retrofit: Retrofit, service: Class<T>): T{
        return retrofit.create(service)
    }
}
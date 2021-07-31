package com.jacob.newsapi.presentation.core.callBack

interface ResultCallBack<T> {

    fun onSuccess(type: T)
    fun onError(message: String, type: T? = null)
}
package com.jacob.newsapi.presentation.core.callBack

interface OnItemClickListener<T>{

    fun onItemClic(item: T, type: String? = null)
}
package com.jacob.newsapi.presentation.news.local.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jacob.newsapi.R
import com.jacob.newsapi.presentation.news.local.model.DataLocal

class LocalViewModel:ViewModel() {

    val localL = MutableLiveData<List<DataLocal>>()

    init {
        getLocalWS()
    }

    private fun getLocalWS() {
        val localVWM = listOf(
            DataLocal(R.drawable.lavadora_automatica_19kg,"saffas", "sddfsf"),
            DataLocal(R.drawable.lavadora_automatica_19kg,"saffas", "sddfsf"),
            DataLocal(R.drawable.lavadora_automatica_19kg,"saffas", "sddfsf"),
            DataLocal(R.drawable.lavadora_automatica_19kg,"saffas", "sddfsf"),
            DataLocal(R.drawable.lavadora_automatica_19kg,"saffas", "sddfsf"),
        )
        localL.postValue(localVWM)
    }
}
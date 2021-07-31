package com.jacob.newsapi.presentation.singUp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.newsapi.data.dataBase.NewsRoomDataBase
import com.jacob.newsapi.presentation.core.callBack.ResultCallBack

class SignUpViewModelFactory(
    private val newsRoomDataBase: NewsRoomDataBase,
    private val resultCallBack: ResultCallBack<String>
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel(
            newsRoomDataBase,
            resultCallBack
        )as T
    }
}
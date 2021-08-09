package com.jacob.newsapi.presentation.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.newsapi.data.local.dataBase.NewsRoomDataBase
import com.jacob.newsapi.data.local.entities.User
import com.jacob.newsapi.presentation.core.callBack.ResultCallBack

class LoginViewModelFactory(
    private val newsRoomDataBase: NewsRoomDataBase,
    private val resultCallBack: ResultCallBack<User>
):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(
            newsRoomDataBase,
            resultCallBack
        )as T
    }
}
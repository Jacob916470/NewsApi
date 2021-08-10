package com.jacob.newsapi.presentation.local.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.newsapi.domain.useCases.GetNewsApiUseCase

class LocalViewModelFactory(
    private val getNewsApiUseCase: GetNewsApiUseCase
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LocalViewModel(
            getNewsApiUseCase
        )as T
    }
}
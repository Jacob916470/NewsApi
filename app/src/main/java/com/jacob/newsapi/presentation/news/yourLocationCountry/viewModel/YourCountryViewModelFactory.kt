package com.jacob.newsapi.presentation.news.yourLocationCountry.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.newsapi.domain.useCases.GetNewsApiUseCase

class YourCountryViewModelFactory(
    private val getNewsApiUseCase: GetNewsApiUseCase
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return YourLocationViewModel(
            getNewsApiUseCase
        )as T
    }
}
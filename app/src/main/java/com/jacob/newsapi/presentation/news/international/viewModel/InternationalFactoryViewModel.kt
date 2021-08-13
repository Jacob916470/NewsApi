package com.jacob.newsapi.presentation.news.international.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.newsapi.domain.useCases.GetNewsApiUseCase

class InternationalFactoryViewModel(
    private val getNewsApiUseCase: GetNewsApiUseCase
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InternationalViewModel(
            getNewsApiUseCase
        )as T
    }
}
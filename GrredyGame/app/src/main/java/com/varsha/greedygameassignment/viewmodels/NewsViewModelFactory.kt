package com.varsha.greedygameassignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.varsha.greedygameassignment.repository.NewsRepository

/**
 * This class is responsible for creating object of viewModel
 */
class NewsViewModelFactory(private val newsRepository: NewsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}
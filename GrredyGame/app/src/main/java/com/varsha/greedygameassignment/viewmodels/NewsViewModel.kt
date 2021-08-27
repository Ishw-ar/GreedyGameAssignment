package com.varsha.greedygameassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.varsha.greedygameassignment.data.local.NewsEntity
import com.varsha.greedygameassignment.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel class is responsible for interacting with the repository class
 */
class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    fun insertNews() {

        CoroutineScope(Dispatchers.IO).launch {
            repository.insertNews()
        }
    }

    fun getNews(): LiveData<List<NewsEntity>> {
        return repository.getNews()
    }

    fun getCount(): Int {
        return repository.getCount()
    }
    fun searchDatabase(searchQuery: String): LiveData<List<NewsEntity>> {
        return repository.searchDatabase(searchQuery).asLiveData()
    }

}
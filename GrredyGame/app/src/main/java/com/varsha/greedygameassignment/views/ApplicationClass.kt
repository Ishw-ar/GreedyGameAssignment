package com.varsha.greedygameassignment.views

import android.app.Application
import com.varsha.greedygameassignment.data.local.NewsDatabase
import com.varsha.greedygameassignment.data.local.SaveNewsDatabase
import com.varsha.greedygameassignment.repository.NewsRepository

class ApplicationClass:Application() {
    val newsDao by lazy {
        val roomDatabase=NewsDatabase.getNewsDatabase(this)
        roomDatabase.getMyNewsDao()
    }
    val repository:NewsRepository by lazy {
       NewsRepository(newsDao)
    }
    val saveNewsDao by lazy {
        val roomDatabase=SaveNewsDatabase.getSaveNewsDatabase(this)
        roomDatabase.getMySaveNewsDao()
    }

}
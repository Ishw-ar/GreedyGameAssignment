package com.varsha.greedygameassignment.views.interfaces
import com.varsha.greedygameassignment.data.local.NewsEntity

interface ItemClickListener {
    fun onItemClicked(newsEntity: NewsEntity)
}
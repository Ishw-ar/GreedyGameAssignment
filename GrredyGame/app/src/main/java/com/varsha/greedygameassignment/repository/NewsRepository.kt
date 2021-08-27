package com.varsha.greedygameassignment.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import com.varsha.greedygameassignment.data.local.NewsDao
import com.varsha.greedygameassignment.data.local.NewsEntity
import com.varsha.greedygameassignment.data.remote.ApiServices
import kotlinx.coroutines.flow.Flow

import java.net.URL


/**
 * This is Repository class which is responsible for interacting with the database
 */
class NewsRepository(private val newsDao: NewsDao) {


    private val api = ApiServices.instance

    /**
     * This function will insert all the items in the Room Database
     */
    suspend fun insertNews() {
        val result = api.getLatestNews()
        for (i in result.articles.indices) {
            if(result.articles[i].urlToImage!=null && result.articles[i].title!=null
                && result.articles[i].description!=null && result.articles[i].publishedAt!=null) {
                val myEntity =
                    NewsEntity(
                        result.articles[i].urlToImage,
                        result.articles[i].title,
                        result.articles[i].description,
                        result.articles[i].publishedAt
                    )
                newsDao.insertNews(myEntity)
            }
        }

    }

    /**
     * This function will return all the items from the Database
     */
    fun getNews(): LiveData<List<NewsEntity>> {
        return newsDao.getNews()
    }

    /**
     * This function will convert url to Bitmap
     */
    private fun gettingBitmap(url: String): Bitmap {
        val mUrl = URL(url)
        val image: Bitmap = BitmapFactory.decodeStream(mUrl.openConnection().getInputStream())
        return image
    }

    /**
     * This function will return  the total number of row from database table
     */
    fun getCount(): Int {
        return newsDao.count()

    }
    /**
     * This function will will return the row of items based on the query string from the database
     */
    fun searchDatabase(searchQuery: String): Flow<List<NewsEntity>> {
        return newsDao.searchDatabase(searchQuery)
    }

}
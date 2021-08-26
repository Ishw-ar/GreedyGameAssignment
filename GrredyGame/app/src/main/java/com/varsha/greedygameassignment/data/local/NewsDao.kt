package com.varsha.greedygameassignment.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    /**
     * This function will insert all the items in the Database
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNews(myEntity: NewsEntity)

    /**
     * This function will return all the items from the Database
     */
    @Query("select * from my_news_table")
    fun getNews(): LiveData<List<NewsEntity>>

    /**
     * This function will return  the total number of row from database table
     */
    @Query("SELECT COUNT(*) FROM my_news_table")
    fun count(): Int


}
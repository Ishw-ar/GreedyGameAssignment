package com.varsha.greedygameassignment.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SaveNewsDao {

    /**
     * This function will insert all the items in the Database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSaveNews(myEntity: SaveNewsEntity)

    /**
     * This function will return all the items from the Database
     */
    @Query("select * from my_save_news_table")
    fun getSaveNews(): LiveData<List<SaveNewsEntity>>




}
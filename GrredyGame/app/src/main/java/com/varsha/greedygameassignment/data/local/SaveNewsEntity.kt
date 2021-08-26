package com.varsha.greedygameassignment.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * This is the structure of our table in the database
 */
@Entity(tableName = "my_save_news_table")
data class SaveNewsEntity(
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "hashtag") val hashtag: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "author") val author: String

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}
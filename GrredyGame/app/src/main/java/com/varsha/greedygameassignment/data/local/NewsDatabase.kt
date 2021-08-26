package com.varsha.greedygameassignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {

    /**
     * This function will used for initialize the Dao class
     */
    abstract fun getMyNewsDao(): NewsDao

    companion object {

        private var INSTANCE: NewsDatabase? = null


        /**
         * This function return the database reference
         */
        fun getNewsDatabase(context: Context): NewsDatabase {
            return if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news_database"
                )

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()

                INSTANCE!!
            } else {
                INSTANCE!!
            }
        }

    }
}
package com.varsha.greedygameassignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SaveNewsEntity::class], version = 1)
abstract class SaveNewsDatabase : RoomDatabase() {

    /**
     * This function will used for initialize the Dao class
     */
    abstract fun getMySaveNewsDao(): SaveNewsDao

    companion object {

        private var INSTANCE: SaveNewsDatabase? = null


        /**
         * This function return the database reference
         */
        fun getSaveNewsDatabase(context: Context): SaveNewsDatabase {
            return if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    SaveNewsDatabase::class.java,
                    "save_news_database"
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
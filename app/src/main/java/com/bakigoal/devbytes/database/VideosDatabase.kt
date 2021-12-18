package com.bakigoal.devbytes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bakigoal.devbytes.database.dao.VideoDao
import com.bakigoal.devbytes.database.entity.VideoEntity

@Database(entities = [VideoEntity::class], version = 1)
abstract class VideosDatabase : RoomDatabase() {
    abstract val videoDao: VideoDao

    companion object {

        @Volatile
        private lateinit var INSTANCE: VideosDatabase

        fun getDatabase(context: Context): VideosDatabase {
            if (::INSTANCE.isInitialized) {
                return INSTANCE
            }
            initDb(context)
            return INSTANCE
        }

        private fun initDb(context: Context) = synchronized(this) {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, VideosDatabase::class.java, "videos"
                )
                    .build()
            }
        }
    }
}
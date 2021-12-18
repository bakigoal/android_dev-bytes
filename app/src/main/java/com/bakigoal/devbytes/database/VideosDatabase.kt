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
}

private lateinit var INSTANCE: VideosDatabase

fun getDatabase(context: Context): VideosDatabase {
    synchronized(VideosDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                VideosDatabase::class.java,
                "videos"
            )
                .build()
        }
    }
    return INSTANCE
}
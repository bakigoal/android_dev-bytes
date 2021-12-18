package com.bakigoal.devbytes.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bakigoal.devbytes.database.entity.VideoEntity

@Dao
interface VideoDao {

    @Query("select * from db_video")
    fun getVideos(): LiveData<List<VideoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg videos: VideoEntity)
}
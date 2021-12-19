package com.bakigoal.devbytes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.bakigoal.devbytes.database.VideosDatabase
import com.bakigoal.devbytes.database.entity.toDomainModel
import com.bakigoal.devbytes.domain.Video
import com.bakigoal.devbytes.network.Network
import com.bakigoal.devbytes.network.dto.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for fetching devbytes from the network and storing them on disk
 */
class VideosRepository(private val database: VideosDatabase) {

    val videos: LiveData<List<Video>> =
        Transformations.map(database.videoDao.getVideos()) { it.toDomainModel() }

    suspend fun refreshVideos() = withContext(Dispatchers.IO) {
        val playlist = Network.devbytes.getPlaylistAsync().await()
        database.videoDao.insertAll(*playlist.toEntity())
    }
}
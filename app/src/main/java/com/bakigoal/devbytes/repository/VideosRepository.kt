package com.bakigoal.devbytes.repository

import com.bakigoal.devbytes.database.VideosDatabase
import com.bakigoal.devbytes.network.Network
import com.bakigoal.devbytes.network.dto.asDbModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for fetching devbytes from the network and storing them on disk
 */
class VideosRepository (private val database: VideosDatabase){

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = Network.devbytes.getPlaylistAsync().await()
            database.videoDao.insertAll(*playlist.asDbModel())
        }
    }
}
package com.bakigoal.devbytes.network.service

import com.bakigoal.devbytes.network.dto.VideoPlaylistDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * A retrofit service to fetch a devbyte playlist.
 */
interface DevbyteService {

    @GET("devbytes.json")
    fun getPlaylistAsync(): Deferred<VideoPlaylistDto>
}
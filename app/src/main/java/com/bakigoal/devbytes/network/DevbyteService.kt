package com.bakigoal.devbytes.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * A retrofit service to fetch a devbyte playlist.
 */
interface DevbyteService {

    @GET("devbytes.json")
    fun getPlaylistAsync(): Deferred<VideoPlaylistDto>
}
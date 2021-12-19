package com.bakigoal.devbytes.network.dto

import com.bakigoal.devbytes.database.entity.VideoEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoPlaylistDto(
    val videos: List<VideoDto>
)

/**
 * Convert Dto to database objects
 */
fun VideoPlaylistDto.toEntity(): Array<VideoEntity> = videos.map(VideoDto::toEntity).toTypedArray()
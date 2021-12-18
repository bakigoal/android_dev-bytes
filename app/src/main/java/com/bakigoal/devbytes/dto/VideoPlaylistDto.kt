package com.bakigoal.devbytes.dto

import com.bakigoal.devbytes.domain.Video
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoPlaylistDto(
    val videos: List<VideoDto>
)

/**
 * Convert Dto to database objects
 */
fun VideoPlaylistDto.asDomainModel(): List<Video> {
    return videos.map(VideoDto::asDomainModel)
}
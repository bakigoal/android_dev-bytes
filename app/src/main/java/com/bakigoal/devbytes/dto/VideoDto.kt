package com.bakigoal.devbytes.dto

import com.bakigoal.devbytes.domain.Video
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoDto(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String,
    val closedCaptions: String?
)

/**
 * Convert Dto to database objects
 */
fun VideoDto.asDomainModel(): Video {
    return Video(
        title = title,
        description = description,
        url = url,
        updated = updated,
        thumbnail = thumbnail
    )
}
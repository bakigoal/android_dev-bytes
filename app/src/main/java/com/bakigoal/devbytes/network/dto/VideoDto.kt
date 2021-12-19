package com.bakigoal.devbytes.network.dto

import com.bakigoal.devbytes.database.entity.VideoEntity
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
fun VideoDto.toEntity(): VideoEntity = VideoEntity(
    title = title,
    description = description,
    url = url,
    updated = updated,
    thumbnail = thumbnail
)
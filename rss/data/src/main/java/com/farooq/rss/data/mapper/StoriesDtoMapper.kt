package com.farooq.rss.data.mapper

import com.farooq.rss.data.local.model.StoriesEntity
import com.farooq.rss.data.remote.dto.StoriesDto

fun List<StoriesDto.ChannelDto.ItemDto>.toStoriesEntityList(): List<StoriesEntity> {
    return this.map {
        StoriesEntity(
            title = it.title ?: "",
            description = it.description ?: "",
            category = it.category ?: "IS NOT Null",
            image = it.content ?: "",
            link = it.link ?: ""
        )
    }
}
package com.farooq.rss.data.mapper

import com.farooq.rss.data.local.model.StoriesEntity
import com.farooq.rss.domain.model.Story

fun List<StoriesEntity>.toStoriesList(): List<Story> {
    return this.map {
        Story(
            title = it.title,
            description = it.description,
            category = it.category,
            image = it.image,
            link = it.link
        )
    }
}
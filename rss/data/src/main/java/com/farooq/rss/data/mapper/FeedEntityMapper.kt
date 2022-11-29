package com.farooq.rss.data.mapper

import com.farooq.rss.data.local.model.FeedsEntity
import com.farooq.rss.domain.model.Feed


fun List<FeedsEntity>.toFeedsList(): List<Feed> {
    return this.map {
        Feed(
            title = it.title,
            description = it.description,
            category = it.category,
            image = it.image
        )
    }
}
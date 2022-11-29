package com.farooq.rss.data.mapper

import com.farooq.rss.data.local.model.FeedsEntity
import com.farooq.rss.data.remote.dto.ItemDto

fun List<ItemDto>.toFeedsEntityList(): List<FeedsEntity> {
    return this.map {
        FeedsEntity(
            title = it.title ?: "",
            description = it.description ?: "",
            category = it.category ?: "IS NOT Null",
            image = it.content ?: ""
        )
    }
}
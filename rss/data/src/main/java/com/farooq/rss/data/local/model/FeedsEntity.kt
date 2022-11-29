package com.farooq.rss.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "feeds_entity")
data class FeedsEntity(
    @PrimaryKey
    val title: String,
    val description: String,
    val category: String,
    val image: String
)

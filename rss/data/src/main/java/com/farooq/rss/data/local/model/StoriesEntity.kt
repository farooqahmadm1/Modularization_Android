package com.farooq.rss.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "stories_entity")
data class StoriesEntity(
    @PrimaryKey
    val title: String,
    val description: String,
    val category: String,
    val image: String,
    val link: String
)
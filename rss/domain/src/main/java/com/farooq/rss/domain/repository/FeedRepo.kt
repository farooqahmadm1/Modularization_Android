package com.farooq.rss.domain.repository


import com.farooq.rss.domain.model.Feed
import kotlinx.coroutines.flow.Flow

interface FeedRepo {
    suspend fun loadFeeds()
    fun getFeeds(): Flow<List<Feed>>
}
package com.farooq.rss.domain.repository

import com.farooq.rss.domain.model.Story
import kotlinx.coroutines.flow.Flow

interface StoriesRepo {
    suspend fun loadStories(feedName: String)
    fun getStories(feedName: String): Flow<List<Story>>
}
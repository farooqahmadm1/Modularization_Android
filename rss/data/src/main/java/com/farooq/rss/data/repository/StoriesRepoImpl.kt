package com.farooq.rss.data.repository

import com.farooq.rss.data.local.dao.StoriesDao
import com.farooq.rss.data.mapper.toStoriesEntityList
import com.farooq.rss.data.mapper.toStoriesList
import com.farooq.rss.data.remote.StoriesService
import com.farooq.rss.domain.repository.StoriesRepo
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StoriesRepoImpl @Inject constructor(
    private val service: StoriesService,
    private val dao: StoriesDao
) : StoriesRepo {

    override fun getStories(feedName: String) = dao.getStories(feedName).map { it.toStoriesList() }

    override suspend fun loadStories(feedName: String) {
        val response = service.getStories(feedName)
        dao.insert(response.channel?.item?.toStoriesEntityList() ?: emptyList())
    }
}
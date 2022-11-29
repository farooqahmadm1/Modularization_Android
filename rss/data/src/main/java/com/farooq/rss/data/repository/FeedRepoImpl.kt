package com.farooq.rss.data.repository

import com.farooq.rss.data.local.dao.FeedsDao
import com.farooq.rss.data.mapper.toFeedsEntityList
import com.farooq.rss.data.mapper.toFeedsList
import com.farooq.rss.data.remote.FeedsService
import com.farooq.rss.domain.repository.FeedRepo
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FeedRepoImpl @Inject constructor(
    private val feedsService: FeedsService,
    private val dao: FeedsDao
) : FeedRepo {

    override suspend fun loadFeeds() {
        val result = feedsService.getFeeds().channel?.item?.toFeedsEntityList() ?: emptyList()
        dao.insert(result)
    }

    override fun getFeeds() = dao.getFeedsList().map { it.toFeedsList() }
}
package com.farooq.rss.domain.use_case

import com.farooq.core.domain.NetworkExceptionHandling
import com.farooq.core.domain.ProgressBarState
import com.farooq.core.domain.Resource
import com.farooq.rss.domain.repository.FeedRepo
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject


class GetFeedsUseCase @Inject constructor(
    private val feedRepo: FeedRepo,
    private val networkExceptionHandling: NetworkExceptionHandling
) {

    operator fun invoke() = callbackFlow {
        trySend(Resource.Loading(ProgressBarState.Loading))
        try {
            feedRepo.loadFeeds()
        } catch (e: Exception) {
            trySend(networkExceptionHandling.execute(e))
        } finally {
            feedRepo.getFeeds().collectLatest { result ->
                trySend(Resource.Success(result))
            }
            trySend(Resource.Loading(ProgressBarState.Idle))
        }
        awaitClose {
            channel.close()
        }
    }
}
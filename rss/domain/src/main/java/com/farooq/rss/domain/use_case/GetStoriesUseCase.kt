package com.farooq.rss.domain.use_case

import com.farooq.core.domain.NetworkExceptionHandling
import com.farooq.core.domain.ProgressBarState
import com.farooq.core.domain.Resource
import com.farooq.rss.domain.repository.StoriesRepo
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class GetStoriesUseCase @Inject constructor(
    private val storiesRepo: StoriesRepo,
    private val networkExceptionHandling: NetworkExceptionHandling
) {

    operator fun invoke(category: String) = callbackFlow {
        trySend(Resource.Loading(ProgressBarState.Loading))
        try {
            storiesRepo.loadStories(category)
        } catch (e: Exception) {
            trySend(networkExceptionHandling.execute(e))
        } finally {
            trySend(Resource.Loading(ProgressBarState.Idle))
            storiesRepo.getStories(category).collectLatest { result ->
                trySend(Resource.Success(result))
            }
        }
        awaitClose {
            channel.close()
        }
    }
}
package com.farooq.rss.ui_feeds

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farooq.core.domain.ProgressBarState
import com.farooq.core.domain.Resource
import com.farooq.rss.domain.model.Feed
import com.farooq.rss.domain.use_case.GetFeedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FeedsViewModel @Inject constructor(
    private val getFeeds: GetFeedsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(FeedsUiState())
    val state : State<FeedsUiState> = _state

    init {
        onEvent(FeedsEvent.GetFeeds)
    }

    private fun onEvent(event: FeedsEvent) {
        when (event) {
            is FeedsEvent.GetFeeds -> getFeeds()
        }
    }

    private fun getFeeds() {
        getFeeds.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> _state.value = state.value.copy(feeds = result.data ?: emptyList())
                is Resource.Loading -> _state.value = state.value.copy(isLoading = ProgressBarState.Loading == result.progressBarState)
                is Resource.Error -> _state.value = state.value.copy(error = result.message ?: "")
            }
        }.launchIn(viewModelScope)
    }
}

sealed class FeedsEvent {
    object GetFeeds : FeedsEvent()
}

data class FeedsUiState(
    val feeds: List<Feed> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
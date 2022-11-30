package com.farooq.rss.ui_stories

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farooq.constants.Constant
import com.farooq.core.domain.ProgressBarState
import com.farooq.core.domain.Resource
import com.farooq.rss.domain.model.Story
import com.farooq.rss.domain.use_case.GetStoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StoriesViewModel @Inject constructor(
    private val getStoriesUseCase: GetStoriesUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(StoriesUiState())
    val state: State<StoriesUiState> = _state

    init {
        savedStateHandle.get<String>(Constant.PARAM_FEED_CATEGORY)?.let { category ->
            _state.value = state.value.copy(name = category)
            onEvent(StoriesEvent.GetStories(category))
        }
    }

    private fun onEvent(event: StoriesEvent) {
        when (event) {
            is StoriesEvent.GetStories -> getStories(event.category)
        }
    }

    private fun getStories(category: String) {
        getStoriesUseCase.invoke(category).onEach { result ->
            when (result) {
                is Resource.Success -> _state.value = state.value.copy(stories = result.data ?: emptyList(), error = "")
                is Resource.Loading -> _state.value = state.value.copy(isLoading = ProgressBarState.Loading == result.progressBarState)
                is Resource.Error -> _state.value = state.value.copy(error = result.message ?: "An Expected Error Occurred")
            }
        }.launchIn(viewModelScope)
    }
}

sealed class StoriesEvent {
    data class GetStories(val category: String) : StoriesEvent()
}

data class StoriesUiState(
    val name : String = "",
    val stories: List<Story> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
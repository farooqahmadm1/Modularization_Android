package com.farooq.rss.ui_stories

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eddress.common.presentation.components.TopAppBarContent
import com.eddress.common.presentation.components.handleErrorAndLoading
import com.eddress.common.presentation.navigation.Screen
import com.farooq.core.utils.encodeUrl
import com.farooq.rss.ui_stories.components.StoryListItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StoriesScreen(
    navController: NavController,
    viewModel: StoriesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBarContent(name = "${state.name} Stories") {
                navController.popBackStack()
            }
        },
        content = {
            Box(modifier = Modifier.fillMaxSize().padding(it)) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.stories) { story ->
                        StoryListItem(story = story, Modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp), onItemClick = {
                            navController.navigate(Screen.WebViewScreen.route + "/${story.link.encodeUrl()}/${story.category}")
                        })
                    }
                }
                handleErrorAndLoading(isLoading = state.isLoading, error = state.error)
            }
        },
    )

}
package com.farooq.rss.ui_feeds

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eddress.common.presentation.navigation.Screen
import com.eddress.common.presentation.util.showToast
import com.farooq.rss.ui_feeds.components.FeedListItem


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FeedsScreen(
    navController: NavController,
    viewModel: FeedsViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Feeds") })
        }
    ) {
        val state = viewModel.state.value
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.feeds) { feed ->
                    FeedListItem(feed = feed, onItemClick = {
                        navController.navigate(Screen.StoriesScreen.route + "/${feed.category}")
                    })
                }
            }
            if (state.error.isNotBlank()) {
                LocalContext.current.showToast(state.error)
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
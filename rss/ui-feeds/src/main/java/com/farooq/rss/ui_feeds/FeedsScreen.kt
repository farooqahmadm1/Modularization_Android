package com.farooq.rss.ui_feeds

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eddress.common.presentation.components.handleErrorAndLoading
import com.eddress.common.presentation.navigation.Screen
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
            TopAppBar(
                title = {
                    Text(
                        text = "Feeds",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                })
        },
        content = {
            val state = viewModel.state.value
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.feeds) { feed ->
                        FeedListItem(feed = feed, onItemClick = {
                            navController.navigate(Screen.StoriesScreen.route + "/${feed.category}")
                        })
                    }
                }
                handleErrorAndLoading(isLoading = state.isLoading, error = state.error)
            }
        }
    )
}
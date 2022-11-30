package com.farooq.greyp_task.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eddress.common.presentation.components.WebViewScreen
import com.eddress.common.presentation.navigation.Screen
import com.farooq.constants.Constant
import com.farooq.rss.ui_feeds.FeedsScreen
import com.farooq.rss.ui_stories.StoriesScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.FeedsScreen.route
    ) {
        composable(route = Screen.FeedsScreen.route) {
            FeedsScreen(navController = navController)
        }
        composable(route = Screen.StoriesScreen.route + "/{${Constant.PARAM_FEED_CATEGORY}}") {
            StoriesScreen(navController = navController)
        }
        composable(route = Screen.WebViewScreen.route + "/{${Constant.PARAM_URL}}/{${Constant.PARAM_NAME}}") {
            WebViewScreen(navController = navController)
        }
    }
}
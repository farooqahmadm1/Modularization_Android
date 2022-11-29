package com.eddress.common.presentation.navigation

sealed class Screen(val route: String) {
    object FeedsScreen : Screen("feeds_list_screen")
    object StoriesScreen : Screen("stories_list_screen")
}
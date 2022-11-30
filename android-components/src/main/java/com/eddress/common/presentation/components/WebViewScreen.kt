package com.eddress.common.presentation.components

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.farooq.constants.Constant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebViewScreen(
    navController: NavController,
) {
    val arguments = navController.currentBackStackEntry?.arguments
    val url = arguments?.getString(Constant.PARAM_URL) ?: ""
    Scaffold(
        topBar = {
            TopAppBarContent(name = arguments?.getString(Constant.PARAM_NAME) ?: ""){
                navController.popBackStack()
            }
        },
        content = { MyContent(url) }
    )
}

// Creating a composable
// function to create WebView
// Calling this function as
// content in the above function
@Composable
fun MyContent(url: String) {
    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}
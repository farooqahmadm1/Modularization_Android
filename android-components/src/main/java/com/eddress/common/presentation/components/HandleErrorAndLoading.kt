package com.eddress.common.presentation.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.eddress.common.presentation.util.showToast

@Composable
fun handleErrorAndLoading(
    isLoading: Boolean,
    error: String,
) {
    if (error.isNotBlank()) {
        LocalContext.current.showToast(error)
    }
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
package com.eddress.common.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.eddress.common.presentation.theme.AppTheme

@Composable
fun MyApp(content: @Composable () -> Unit) {
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.surface) {
            content()
        }
    }
}
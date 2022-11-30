package com.eddress.common.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent(
    name: String = "",
    showNavigationIcon: Boolean = true,
    onNavigateBack: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        navigationIcon = {
            if (showNavigationIcon) {
                IconButton(onClick = {
                    if (onNavigateBack != null) {
                        onNavigateBack()
                    }
                }) {
                    Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "back icon", tint = MaterialTheme.colorScheme.primary)
                }
            }
        }
    )
}
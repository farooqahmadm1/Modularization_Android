package com.eddress.common.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eddress.common.presentation.theme.spacing
import kotlinx.coroutines.launch


@Composable
fun Header(
    iconTitle: String? = null,
    primaryTitle: String? = null,
    providePadding: Boolean? = false,
    toolbarBackground: Color = Color.Transparent,
    onNavigateBack: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val separatePadding = if (providePadding == true) MaterialTheme.spacing.horizontal else 0.dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(toolbarBackground)
            .padding(separatePadding)
    ) {
        iconTitle?.let {
            Text(text = it, style = MaterialTheme.typography.labelMedium)
        }
        Box(
            modifier = Modifier.border(width = 1.dp, color = Color(0xFFE0E0E0), shape = RoundedCornerShape(MaterialTheme.spacing.verySmall)),
            contentAlignment = Alignment.Center,
        ) {
            IconButton(
                onClick = {
                    scope.launch {
                        onNavigateBack()
                    }
                },
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .background(Color.Transparent),
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Btn", tint = Color.Black)
            }
        }

        primaryTitle?.let {
            Text(
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth()
                    .align(Alignment.Center),
                style = MaterialTheme.typography.labelMedium.copy(
                    fontSize = 20.sp
                )
            )
        }
    }
}

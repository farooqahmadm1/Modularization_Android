package com.eddress.common.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import com.eddress.common.presentation.theme.spacing
import kotlinx.coroutines.launch


@Composable
fun PrimaryButton(
    title: String = "Primary Btn",
    icon: ImageVector?,
    onClick: (() -> Unit)
) {
    val scope = rememberCoroutineScope()
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.btnMedium)
            .clip(MaterialTheme.shapes.medium),
        onClick = {
            scope.launch {
                onClick()
            }
        }
    ) {
        Text(text = title, style = MaterialTheme.typography.labelMedium)
    }
}

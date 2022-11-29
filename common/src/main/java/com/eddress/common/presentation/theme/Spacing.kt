package com.eddress.common.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val default: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val verySmall: Dp = 8.dp,
    val lessSmall: Dp = 12.dp,
    val small: Dp = 16.dp,
    val medium: Dp = 24.dp,
    val large: Dp = 32.dp,
    val big: Dp = 42.dp,
    val extraLarge: Dp = 60.dp,
    val extraBig: Dp = 100.dp,

    val bigBelowHeader: Dp = 190.dp,
    val smallBelowHeader: Dp = 90.dp,
    val btnSmall: Dp = 40.dp,
    val btnMedium: Dp = 55.dp,
    val btnLarge: Dp = 60.dp,

    val horizontal: Dp = 24.dp,
    val vertical: Dp = 16.dp,
)


val LocalSpacing = compositionLocalOf { Spacing() }
val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current

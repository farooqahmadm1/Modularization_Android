package com.eddress.common.presentation.theme



import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.eddress.common.R


val Fonts = FontFamily(
    Font(R.font.product_sans_regular),
    Font(R.font.proxima_nova_light, weight = FontWeight.Light),
    Font(R.font.product_sans_regular, weight = FontWeight.Normal),
    Font(R.font.proxima_nova_medium, weight = FontWeight.Medium),
    Font(R.font.product_sans_bold, weight = FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
)
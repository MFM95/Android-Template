package com.template.supplier.base.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

val LightColorsPalette = lightColors(
    primary = Cyan,
    primaryVariant = Cyan,
    secondary = Gray,
    secondaryVariant = LightGrayA,
    background = White,
    surface = White,
    error = Red,
    onPrimary = White,
    onSecondary = White,
    onBackground = Black,
    onSurface = Black,
    onError = White
)

private val Shapes = Shapes(
    small = RoundedCornerShape(6.dp),
    medium = RoundedCornerShape(10.dp),
    large = RoundedCornerShape(0.dp)
)


@Composable
fun MainTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorsPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

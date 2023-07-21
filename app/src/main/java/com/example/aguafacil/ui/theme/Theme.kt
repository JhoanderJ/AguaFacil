package com.example.aguafacil.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = blue_600,
    primaryVariant = blue_700,
    secondary = blue_200
)

private val LightColorPalette = lightColors(
    primary = blue_200,
    primaryVariant = blue_100,
    secondary = blue_300
)

@Composable
fun WaterEasyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
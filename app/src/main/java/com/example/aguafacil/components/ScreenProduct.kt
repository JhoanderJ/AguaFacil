package com.example.aguafacil.components

import androidx.compose.runtime.Composable
import com.example.aguafacil.R

@Composable
fun ScreenWithImagens() {
    val value = listOf(
        R.drawable.estractor,
        R.drawable.bidon10litros,
        R.drawable.bidon20litros
    )

    ListProducts(value)

}
package com.example.aguafacil.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.aguafacil.ui.theme.blue_50
import com.example.aguafacil.ui.theme.blue_100


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(blue_50),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Inicio",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = blue_100
        )
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
package com.example.aguafacil.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RequestWater() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.000000953674316.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(width = 253.dp)
            .height(height = 45.dp)
            .clip(shape = RoundedCornerShape(10.000000953674316.dp))
            .background(color = Color(0xffefe3c8))
            .padding(start = 50.000003814697266.dp,
                end = 50.000003814697266.dp,
                top = 15.004829406738281.dp,
                bottom = 13.dp)
    ) {
        Text(
            text = "BUY NOW",
            color = Color(0xff4a2b29),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .width(width = 86.dp)
                .height(height = 25.dp))
    }
}

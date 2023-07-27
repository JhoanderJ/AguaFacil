package com.example.aguafacil.presentation.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.presentation.card.ProductCard
import com.example.aguafacil.ui.theme.*

@Composable
fun ListContentProduct(
    modifier: Modifier = Modifier,
    title: String,
    products: List<Product>,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = DIMENS_16dp, end = DIMENS_16dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_24sp,
                color = Black
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(DIMENS_2dp),
            contentPadding = PaddingValues(DIMENS_8dp)
        ) {
            items(products) { product ->
                ProductCard(productItem = product)
            }
        }
    }
}
package com.example.aguafacil.presentation.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aguafacil.R
import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.ui.theme.GrayBorderStroke
import com.example.aguafacil.ui.theme.GilroyFontFamily
import com.example.aguafacil.ui.theme.DIMENS_80dp
import com.example.aguafacil.ui.theme.Black
import com.example.aguafacil.ui.theme.DIMENS_12dp
import com.example.aguafacil.ui.theme.DIMENS_174dp
import com.example.aguafacil.ui.theme.DIMENS_20dp
import com.example.aguafacil.ui.theme.GraySecondTextColor
import com.example.aguafacil.ui.theme.DIMENS_6dp
import com.example.aguafacil.ui.theme.DIMENS_24dp
import com.example.aguafacil.ui.theme.TEXT_SIZE_16sp
import com.example.aguafacil.ui.theme.TEXT_SIZE_12sp
import com.example.aguafacil.ui.theme.TEXT_SIZE_18sp

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    productItem: Product
) {
    Card(
        shape = RoundedCornerShape(DIMENS_12dp),
        border = BorderStroke(width = 1.dp, color = GrayBorderStroke),
        modifier = modifier
            .padding(DIMENS_12dp)
            .width(DIMENS_174dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DIMENS_12dp)
        ) {
            if (productItem.listProducts?.type == "Dispensador") {
                Image(
                    painter = painterResource(id = R.drawable.estractor),
                    contentDescription = stringResource(R.string.image_product),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .height(DIMENS_80dp)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.bidon20litros),
                    contentDescription = stringResource(R.string.image_product),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .height(DIMENS_80dp)
                )
            }
            Spacer(modifier = Modifier.height(DIMENS_24dp))

            Text(
                text = "${productItem.listProducts?.price}",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Bold,
                color = Black,
                fontSize = TEXT_SIZE_16sp
            )

            Spacer(modifier = Modifier.height(DIMENS_6dp))

            Text(
                text = "${productItem.listProducts?.name}",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Medium,
                color = GraySecondTextColor,
                fontSize = TEXT_SIZE_12sp
            )

            Spacer(modifier = Modifier.height(DIMENS_20dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${productItem.listProducts?.price}",
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Black,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = TEXT_SIZE_18sp
                )
            }

        }
    }
}
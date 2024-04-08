package com.example.aguafacil.presentation.screens.about

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aguafacil.R
import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.presentation.content.ListContentProduct
import com.example.aguafacil.presentation.viewmodel.ProductViewModel
import com.example.aguafacil.ui.theme.DIMENS_24dp
import com.example.aguafacil.utils.ResultState
import com.example.aguafacil.utils.showMsg
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = hiltViewModel()
) {

    val allProducts by viewModel.productList.collectAsState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch(Dispatchers.Main) {
                    viewModel.insert(
                        Product.Products(
                            name = "Agua Fluvial",
                            type = "Botellon",
                            price = "2000",
                            image = 2,
                            description = "Agua potable de 20 litros"
                        )
                    ).collect {
                        when (it) {
                            is ResultState.Success -> {
                                context.showMsg(
                                    msg = it.data
                                )
                            }

                            is ResultState.Failure -> {
                                context.showMsg(
                                    msg = it.message.toString()
                                )
                            }

                            is ResultState.Loading -> {}
                        }
                    }
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Product created"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            for (items in allProducts) {
                val products = items.item
                Spacer(modifier = Modifier.height(DIMENS_24dp))
                ListContentProduct(
                    title = stringResource(id = R.string.exclusive_offer),
                    products = products
                )
                Spacer(modifier = Modifier.height(DIMENS_24dp))
                ListContentProduct(
                    title = stringResource(id = R.string.dispensers_offer),
                    products = products.sortedByDescending { it.listProducts?.type }
                )
            }

        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
package com.example.aguafacil.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.presentation.viewmodel.ProductListViewModel
import com.example.aguafacil.ui.theme.blue_50
import com.example.aguafacil.ui.theme.blue_100
import com.example.aguafacil.utils.ResultState
import com.example.aguafacil.utils.showMsg
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    viewModel: ProductListViewModel = hiltViewModel()
) {
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
                            image = "",
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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {
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
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
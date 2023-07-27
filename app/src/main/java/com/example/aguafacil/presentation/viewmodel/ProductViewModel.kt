package com.example.aguafacil.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.domain.model.ProductState
import com.example.aguafacil.domain.repository.ProductRepository
import com.example.aguafacil.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _productList = MutableStateFlow<List<ProductState>>(emptyList())
    val productList = _productList.asStateFlow()

    fun insert(items: Product.Products) = repository.insert(items)

    init {
        viewModelScope.launch {
            repository.getItems().collect {
                when (it) {
                    is ResultState.Success -> {
                        _productList.value = listOf(
                            ProductState(
                                item = it.data
                            )
                        )
                    }
                    is ResultState.Failure -> {
                        _productList.value = listOf(
                            ProductState(
                                error = it.message.toString()
                            )
                        )
                    }
                    ResultState.Loading -> {
                        _productList.value = listOf(
                            ProductState(
                                isLoading = true
                            )
                        )
                    }
                }
            }
        }
    }
}
package com.example.aguafacil.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.domain.model.ProductState
import com.example.aguafacil.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val mutableState: MutableState<ProductState> = mutableStateOf(ProductState())
    val state: State<ProductState> = mutableState

    fun insert(items : Product.Products) = repository.insert(items)
}
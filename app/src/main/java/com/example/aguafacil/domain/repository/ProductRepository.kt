package com.example.aguafacil.domain.repository

import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun insert(
        item: Product.Products
    ): Flow<ResultState<String>>

    fun getItems(): Flow<ResultState<List<Product>>>

    fun delete(key: String): Flow<ResultState<String>>

    fun update(
        item: Product
    ): Flow<ResultState<String>>

}
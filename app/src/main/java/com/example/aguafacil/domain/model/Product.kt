package com.example.aguafacil.domain.model

data class Product(
    val listProducts: Products?,
    val key: String? = null
) {
    data class Products(
        val name: String? = null,
        val type: String? = null,
        val price: String? = null,
        val image: String? = null,
        val description: String? = null,
    )
}

data class ProductState(
    val item:List<Product> = emptyList(),
    val error:String  = "",
    val isLoading:Boolean = false
)
package com.example.aguafacil.domain.repository

import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.utils.ResultState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ProductDBRepository @Inject constructor(
    private val db: DatabaseReference
) : ProductRepository {

    override fun insert(item: Product.Products): Flow<ResultState<String>> {
        TODO("Not yet implemented")
    }

    override fun getItems(): Flow<ResultState<List<Product>>> = callbackFlow {
        trySend(ResultState.Loading)
        val event = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = snapshot.children.map {
                    Product(
                        it.getValue(Product.Products::class.java),
                        key = it.key
                    )
                }
                trySend(ResultState.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(ResultState.Failure(error.toException()))
            }
        }
        db.addValueEventListener(event)
        awaitClose {
            db.removeEventListener(event)
            close()
        }
    }


    override fun delete(key: String): Flow<ResultState<String>> {
        TODO("Not yet implemented")
    }

    override fun update(item: Product): Flow<ResultState<String>> {
        TODO("Not yet implemented")
    }
}
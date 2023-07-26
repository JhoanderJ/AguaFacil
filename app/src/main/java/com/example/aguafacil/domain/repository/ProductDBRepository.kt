package com.example.aguafacil.domain.repository

import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.utils.ResultState
import com.google.firebase.database.DatabaseReference
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
class ProductDBRepository @Inject constructor(
    private val db: DatabaseReference
) : ProductRepository {

    override fun insert(item: Product.Products): Flow<ResultState<String>> = callbackFlow {
        trySend(ResultState.Loading)
        db.push().setValue(item).addOnCompleteListener {
            if (it.isSuccessful) trySend(ResultState.Success("Inserted Succcessfully"))
        }.addOnFailureListener {
            trySend(ResultState.Failure(it))
        }
        awaitClose {
            close()
        }
    }

    override fun getItems(): Flow<ResultState<List<Product>>> = callbackFlow {
        TODO("Not yet implemented")
    }

    override fun delete(key: String): Flow<ResultState<String>> = callbackFlow {
        TODO("Not yet implemented")
    }

    override fun update(item: Product): Flow<ResultState<String>> = callbackFlow {
        TODO("Not yet implemented")
    }
}
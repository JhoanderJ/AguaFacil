package com.example.aguafacil.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aguafacil.domain.model.Product
import com.example.aguafacil.utils.ResultState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
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
    private val dataBase: DatabaseReference
) : ProductRepository {

    private val _productListLiveData = MutableLiveData<List<Product>>()
    val productListLiveData: LiveData<List<Product>> get() = _productListLiveData


    override fun insert(item: Product.Products): Flow<ResultState<String>> = callbackFlow {
        trySend(ResultState.Loading)
        dataBase.push().setValue(item).addOnCompleteListener {
            if (it.isSuccessful) trySend(ResultState.Success("Inserted Succcessfully"))
        }.addOnFailureListener {
            trySend(ResultState.Failure(it))
        }
        awaitClose {
            close()
        }
    }

    override fun getItems(): Flow<ResultState<List<Product>>> = callbackFlow {
        trySend(ResultState.Loading)
        val valueEvent = object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                trySend(ResultState.Success(buildDataWithSnapshotResponse(snapshot)))
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(ResultState.Failure(error.toException()))
            }

        }

        dataBase.addValueEventListener(valueEvent)
        awaitClose {
            dataBase.removeEventListener(valueEvent)
            close()
        }
    }

    private fun buildDataWithSnapshotResponse(snapshot: DataSnapshot): MutableList<Product> {
        val productList = mutableListOf<Product>()
        for (productSnapshot in snapshot.children) {
            val key = productSnapshot.key ?: ""
            val productMap = productSnapshot.value as? HashMap<*, *>
            val name = productMap?.get("name") as? String
            val type = productMap?.get("type") as? String
            val price = productMap?.get("price") as? String
            val image = productMap?.get("image") as? Int
            val description = productMap?.get("description") as? String
            val product = Product(Product.Products(name, type, price, image, description), key)
            productList.add(product)
        }
        return productList
    }

    override fun delete(key: String): Flow<ResultState<String>> = callbackFlow {
        TODO("Not yet implemented")
    }

    override fun update(item: Product): Flow<ResultState<String>> = callbackFlow {
        TODO("Not yet implemented")
    }
}
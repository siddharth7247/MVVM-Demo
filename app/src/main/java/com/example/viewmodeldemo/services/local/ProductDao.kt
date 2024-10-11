package com.example.viewmodeldemo.services.local
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.viewmodeldemo.model.ProductModel

@Dao
interface ProductDao {

    @Query("Select * from products")
    suspend fun getProducts() : List<ProductModel>

    @Insert
    suspend fun insertAll(products : List<ProductModel>)
}
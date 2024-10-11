package com.example.viewmodeldemo.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.viewmodeldemo.model.ProductModel
import com.example.viewmodeldemo.services.local.ProductDatabase
import com.example.viewmodeldemo.services.remote.ProductService
import com.example.viewmodeldemo.utils.NetworkUtils

class ProductsRepository(val productService: ProductService,val productDatabase: ProductDatabase,val context: Context){

    val productsLiveData = MutableLiveData<List<ProductModel>>()
    val products : LiveData<List<ProductModel>> get() = productsLiveData

    suspend fun getProducts(){

        if(NetworkUtils.isInternetAvailable(context)){
            val result = productService.getProducts()
            if(result.body() != null){
                productDatabase.productDao().insertAll(result.body()!!)
                productsLiveData.postValue(result.body())
            }
        }else{
            val products = productDatabase.productDao().getProducts()
            productsLiveData.postValue(products)
        }
    }
}
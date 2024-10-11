package com.example.viewmodeldemo.services.remote

import com.example.viewmodeldemo.model.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("/products")
    suspend fun getProducts() : Response<List<ProductModel>>
}
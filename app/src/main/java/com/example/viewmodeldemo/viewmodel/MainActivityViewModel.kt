package com.example.viewmodeldemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodeldemo.model.ProductModel
import com.example.viewmodeldemo.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(val repository: ProductsRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getProducts()
        }
    }
    val products : LiveData<List<ProductModel>> get() = repository.products
}
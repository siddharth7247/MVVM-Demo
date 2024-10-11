package com.example.viewmodeldemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.repository.ProductsRepository

class MainViewModelFactory(private val productsRepository: ProductsRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(productsRepository) as T
    }
}
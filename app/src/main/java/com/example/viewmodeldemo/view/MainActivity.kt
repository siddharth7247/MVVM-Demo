package com.example.viewmodeldemo.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodeldemo.R
import com.example.viewmodeldemo.adapter.ProductAdapter
import com.example.viewmodeldemo.databinding.ActivityMainBinding
import com.example.viewmodeldemo.model.ProductModel
import com.example.viewmodeldemo.repository.ProductsRepository
import com.example.viewmodeldemo.services.local.ProductDatabase
import com.example.viewmodeldemo.services.remote.ProductService
import com.example.viewmodeldemo.services.remote.RetrofitHelper
import com.example.viewmodeldemo.viewmodel.MainActivityViewModel
import com.example.viewmodeldemo.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel : MainActivityViewModel
    lateinit var productRecyclerView : RecyclerView
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productRecyclerView = findViewById(R.id.productRecyclerView)

        var productlist : List<ProductModel> = listOf()
        val productService = RetrofitHelper.GetRetrofitInstance().create(ProductService::class.java)
        val productDatabase = ProductDatabase.getDatabase(this)
        val repository = ProductsRepository(productService,productDatabase,this)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainActivityViewModel::class.java)
        mainViewModel.products.observe(this) { list ->
            productlist = list
            Log.d("Productas", productlist.toString())
            productAdapter = ProductAdapter(productlist)
            productRecyclerView.adapter = productAdapter
        }
    }
}
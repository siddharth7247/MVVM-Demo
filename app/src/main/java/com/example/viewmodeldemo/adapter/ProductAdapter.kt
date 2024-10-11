package com.example.viewmodeldemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.viewmodeldemo.R
import com.example.viewmodeldemo.model.ProductModel

class ProductAdapter(val productsList: List<ProductModel>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductViewHolder(view)
    }

    class ProductViewHolder(productView : View) : RecyclerView.ViewHolder(productView){
        val txtTitle = productView.findViewById<TextView>(R.id.txtTitle)
        val txtPrice = productView.findViewById<TextView>(R.id.txtPrice)
        val txtCategory = productView.findViewById<TextView>(R.id.txtCategory)
        val imageView = productView.findViewById<ImageView>(R.id.productImage)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        val currentProduct = productsList[position]
        holder.txtTitle.text = currentProduct.title
        holder.txtPrice.text = currentProduct.price.toString()
        holder.txtCategory.text = currentProduct.category
        holder.imageView.load(currentProduct.image)
    }

    override fun getItemCount() = productsList.size
}
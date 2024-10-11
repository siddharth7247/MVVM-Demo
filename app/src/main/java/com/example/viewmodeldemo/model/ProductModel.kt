package com.example.viewmodeldemo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "products")
data class ProductModel(
    @PrimaryKey(autoGenerate = true) var id : Int,
    @ColumnInfo(name = "title") var title : String,
    @ColumnInfo(name = "price")var price : Double,
    @ColumnInfo(name="category") var category:String,
    @ColumnInfo(name = "image") var image: String
) : Serializable

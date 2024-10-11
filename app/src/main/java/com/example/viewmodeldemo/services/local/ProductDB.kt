package com.example.viewmodeldemo.services.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.viewmodeldemo.model.ProductModel

@Database(entities = [ProductModel::class], version = 2)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDao
    companion object{
        private var INSTANCE : ProductDatabase? = null
        fun getDatabase(context: Context):ProductDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,ProductDatabase::class.java,"productsDB").fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE!!
        }
    }
}
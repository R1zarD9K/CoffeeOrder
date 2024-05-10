package com.d3if3136.coffeeorder.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.d3if3136.coffeeorder.database.OrderDao
import com.d3if3136.coffeeorder.screen.DetailViewModel
import com.d3if3136.coffeeorder.screen.MainViewModel

class ViewModelFactory(
    private val dao: OrderDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        } else if ( modelClass.isAssignableFrom(DetailViewModel::class.java) ) {
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
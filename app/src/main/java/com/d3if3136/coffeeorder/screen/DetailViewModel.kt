package com.d3if3136.coffeeorder.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if3136.coffeeorder.database.OrderDao
import com.d3if3136.coffeeorder.model.Order
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: OrderDao) : ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama: String, isi: String, meja: Int) {
        val order = Order (
            tanggal = formatter.format(Date()),
            nama = nama,
            order = isi,
            meja = meja
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(order)
        }
    }

    suspend fun getOrder(id: Long): Order? {
        return dao.getOrderById(id)
    }

    fun update(id: Long, nama: String, isi: String, meja: Int) {
        val order = Order(
            id = id,
            tanggal = formatter.format(Date()),
            nama = nama,
            order = isi,
            meja = meja
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(order)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }

}
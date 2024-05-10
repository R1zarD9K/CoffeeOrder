package com.d3if3136.coffeeorder.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if3136.coffeeorder.database.OrderDao
import com.d3if3136.coffeeorder.model.Order
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: OrderDao) : ViewModel() {

    val data: StateFlow<List<Order>> = dao.getOrder().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

}
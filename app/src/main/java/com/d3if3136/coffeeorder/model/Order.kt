package com.d3if3136.coffeeorder.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val order: String,
    val meja: Int,
    val tanggal: String
)
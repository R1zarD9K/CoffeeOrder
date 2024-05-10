package com.d3if3136.coffeeorder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.d3if3136.coffeeorder.model.Order

@Database(entities = [Order::class], version = 1, exportSchema = false)
abstract class OrderDb : RoomDatabase() {

    abstract val dao: OrderDao

    companion object {

        @Volatile
        private var INSTANCE: OrderDb? = null

        fun getInstance(context: Context): OrderDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        OrderDb::class.java,
                        "catatan.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
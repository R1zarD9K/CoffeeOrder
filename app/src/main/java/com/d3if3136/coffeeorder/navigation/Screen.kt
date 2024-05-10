package com.d3if3136.coffeeorder.navigation

import com.d3if3136.coffeeorder.screen.KEY_ID_ORDER


sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_ORDER}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}
package com.example.bookquiz.compose

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val navArgument: List<NamedNavArgument> = emptyList()
) {
    data object Home : Screen(route = "home")
}
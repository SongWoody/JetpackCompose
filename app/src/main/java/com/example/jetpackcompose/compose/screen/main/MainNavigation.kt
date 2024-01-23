package com.example.jetpackcompose.compose.screen.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.mainScreen() {
    composable(route = MainRoute.route) {
        MainScreen()
    }
}

object MainRoute {
    const val route = "MainRoute"
}
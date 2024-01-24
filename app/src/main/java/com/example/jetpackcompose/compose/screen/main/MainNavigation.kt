package com.example.jetpackcompose.compose.screen.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.mainScreen(navController: NavHostController) {
    composable(route = MainRoute.route) {
        MainScreen(navController)
    }
}

object MainRoute {
    const val route = "MainRoute"
}
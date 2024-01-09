package com.example.jetpackcompose.compose.navigation

import androidx.navigation.NamedNavArgument


sealed class MyNavType(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    object FontSizeChecker: MyNavType("FontSizeChecker")
    object Input: MyNavType("Input")
    object ColorChecker: MyNavType("ColorChecker")
}
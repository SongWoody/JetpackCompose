package com.example.jetpackcompose.compose.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.compose.screen.DemoScreen
import com.example.jetpackcompose.compose.screen.InputScreen

@ExperimentalMaterial3Api
@Composable
fun MyNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MyNavType.Demo.route
    ) {
        composable(MyNavType.Demo.route) {
            DemoScreen(
                modifier = Modifier,
                onNavigateToInput = {
                    navController.navigate(MyNavType.Input.route)
                }
            )
        }
        composable(MyNavType.Input.route) {
            InputScreen(modifier = Modifier) { }
        }
    }
}
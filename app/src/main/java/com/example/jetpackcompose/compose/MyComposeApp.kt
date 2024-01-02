package com.example.jetpackcompose.compose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.compose.screen.DemoScreen
import com.example.jetpackcompose.compose.screen.InputScreen
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

sealed class Screen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    object Demo: Screen("Demo")
    object Input: Screen("Input")
}

@ExperimentalMaterial3Api
@Composable
fun MyComposeApp() {
    val navController = rememberNavController()
    JetpackComposeTheme {
        MyNavHost(
            navController = navController
        )
    }
}


@ExperimentalMaterial3Api
@Composable
fun MyNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Demo.route
    ) {
        composable(Screen.Demo.route) {
            DemoScreen(
                modifier = Modifier,
                onNavigateToInput = {
                    navController.navigate(Screen.Input.route)
                }
            )
        }
        composable(Screen.Input.route) {
            InputScreen(modifier = Modifier) { }
        }
    }
}
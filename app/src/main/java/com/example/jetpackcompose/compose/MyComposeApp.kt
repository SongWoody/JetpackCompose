package com.example.jetpackcompose.compose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.compose.navigation.MyNavHost
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

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
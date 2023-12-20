package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.scenes.DemoScene
import com.example.jetpackcompose.scenes.InputScene
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

enum class Screens {
    Demo,
    Input,
}

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                MyNavHost()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun MyNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Demo.name
    ) {
        composable(Screens.Demo.name) {
            DemoScene(
                modifier = Modifier,
                onNavigateToInput = {
                    navController.navigate(Screens.Input.name)
                }
            )
        }
        composable(Screens.Input.name) {
            InputScene(modifier = Modifier) { }
        }
    }
}
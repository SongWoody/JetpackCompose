package com.example.jetpackcompose.compose.navigation

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpackcompose.compose.screen.fontsizechecker.FontSizeCheckerScreen
import com.example.jetpackcompose.compose.screen.InputScreen
import com.example.jetpackcompose.compose.screen.colorchecker.ColorCheckerRoute
import com.example.jetpackcompose.compose.screen.colorchecker.ColorCheckerScreen
import com.example.jetpackcompose.compose.screen.colorchecker.colorCheckerNavGraph
import com.example.jetpackcompose.compose.ui.ComposeTwoButtonDialogInfo

@ExperimentalMaterial3Api
@Composable
fun MyNavHost(
    navController: NavHostController,
    onShowTwoButtonDialog: (ComposeTwoButtonDialogInfo)->Unit
) {
    NavHost(
        navController = navController,
        startDestination = ColorCheckerRoute.route
    ) {
        composable(MyNavType.FontSizeChecker.route) { entry ->
            Log.i("Woody", "Demo Screen")
            val welcomeText = entry.savedStateHandle.get<String>("message") ?: "Welcome to Compose"
            FontSizeCheckerScreen(
                modifier = Modifier,
                welcomeText = welcomeText,
                onNavigateToInput = {
                    navController.navigate("${MyNavType.Input.route}/defaultText=${welcomeText}")
                }
            )
        }
        composable(
            "${MyNavType.Input.route}/defaultText={defaultText}",
            arguments = listOf(
                navArgument("defaultText") { type = NavType.StringType}
            )
        ) { entry ->
            Log.i("Woody", "Input Screen")
            val text = entry.arguments?.getString("defaultText") ?: ""
            InputScreen(modifier = Modifier, text = text) {
                navController.previousBackStackEntry?.savedStateHandle?.set("message", it)
                navController.popBackStack()
            }
        }

        colorCheckerNavGraph(onShowTwoButtonDialog)
    }
}
package com.example.jetpackcompose.compose.screen.fontsizechecker

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.jetpackcompose.compose.screen.fontInput.FontInputRoute
import com.example.jetpackcompose.compose.ui.ComposeTwoButtonDialogInfo

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.fontCheckerNavigation(
    navController: NavHostController,
    onShowTwoButtonDialog: (ComposeTwoButtonDialogInfo)->Unit
) {
    composable(route = FontCheckerRoute.route) { entry ->
        val welcomeText = entry.savedStateHandle.get<String>("message") ?: "Welcome to Compose"
        FontSizeCheckerScreen(
            modifier = Modifier,
            welcomeText = welcomeText,
            onNavigateToInput = {
                navController.navigate("${FontInputRoute.route}/defaultText=${welcomeText}")
            }
        )
    }
}

object FontCheckerRoute {
    const val route = "FontSizeChecker"
}
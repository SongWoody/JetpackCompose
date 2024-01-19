package com.example.jetpackcompose.compose.screen.fontsizechecker

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.jetpackcompose.R
import com.example.jetpackcompose.compose.etc.TextResource
import com.example.jetpackcompose.compose.screen.fontInput.navigateFontInput
import com.example.jetpackcompose.compose.ui.ComposeTwoButtonDialogInfo

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.fontCheckerNavigation(
    navController: NavHostController,
    onShowTwoButtonDialog: (ComposeTwoButtonDialogInfo)->Unit
) {
    composable(route = FontCheckerRoute.route) { entry ->
        val welcomeText = entry.savedStateHandle.get<String>("message") ?: TextResource(R.string.app_name).getString()
        FontSizeCheckerScreen(
            modifier = Modifier,
            welcomeText = welcomeText,
            onNavigateToInput = {
                navController.navigateFontInput(welcomeText)
            }
        )
    }
}

object FontCheckerRoute {
    const val route = "FontSizeChecker"
}
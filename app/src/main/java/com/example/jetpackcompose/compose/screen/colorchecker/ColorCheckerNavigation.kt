package com.example.jetpackcompose.compose.screen.colorchecker

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.jetpackcompose.compose.ui.ComposeTwoButtonDialogInfo

fun NavGraphBuilder.colorCheckerNavGraph(
    onShowTwoButtonDialog: (ComposeTwoButtonDialogInfo)->Unit
) {
    composable(route = ColorCheckerRoute.route) {
        ColorCheckerScreen(onShowTwoButtonDialog)
    }
}

object ColorCheckerRoute {
    const val route = "ColorChecker"
}
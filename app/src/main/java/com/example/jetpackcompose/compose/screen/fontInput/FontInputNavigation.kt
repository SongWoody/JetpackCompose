package com.example.jetpackcompose.compose.screen.fontInput

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpackcompose.compose.ui.ComposeTwoButtonDialogInfo

fun NavGraphBuilder.fontInputNavGraph(
    navController: NavHostController,
    onShowTwoButtonDialog: (ComposeTwoButtonDialogInfo)->Unit
) {
    composable(
        "${FontInputRoute.route}/defaultText={defaultText}",
        arguments = listOf(
            navArgument("defaultText") { type = NavType.StringType}
        )
    ) { entry ->
        val text = entry.arguments?.getString("defaultText") ?: ""
        FontInputScreen(modifier = Modifier, text = text) {
            navController.previousBackStackEntry?.savedStateHandle?.set("message", it)
            navController.popBackStack()
        }
    }
}

object FontInputRoute {
    const val route = "FontInput"
}
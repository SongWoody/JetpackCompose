package com.example.jetpackcompose.compose.screen.main.tab

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.firstTabScreen() {
    composable(FirstScreenRoute.route) {
        FirstTabScreen()
    }
}

@Composable
fun FirstTabScreen() {
    Box {
        Text(
            modifier = Modifier.align(Alignment.BottomCenter) ,
            text = "FirstTabScreen"
        )
    }
}

@Preview
@Composable
fun PreFirstTabScreen() {
    FirstTabScreen()
}

object FirstScreenRoute {
    const val route = "FirstScreen"
}
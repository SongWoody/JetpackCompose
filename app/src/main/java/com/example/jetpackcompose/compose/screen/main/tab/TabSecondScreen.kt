package com.example.jetpackcompose.compose.screen.main.tab

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.secondTabScreen() {
    composable(SecondScreenRoute.route) {
        SecondTabScreen()
    }
}
@Composable
fun SecondTabScreen() {
    Box {
        Text(
            modifier = Modifier.align(Alignment.BottomCenter) ,
            text = "SecondTabScreen"
        )
    }
}

@Preview
@Composable
fun PreSecondTabScreen() {
    SecondTabScreen()
}


object SecondScreenRoute {
    const val route = "SecondScreen"
}

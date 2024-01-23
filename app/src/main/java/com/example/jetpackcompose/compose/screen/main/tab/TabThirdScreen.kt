package com.example.jetpackcompose.compose.screen.main.tab

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.thirdTabScreen() {
    composable(ThirdScreenRoute.route) {
        ThirdTabScreen()
    }
}

@Composable
fun ThirdTabScreen() {
    Box {
        Text(
            modifier = Modifier.align(Alignment.BottomCenter) ,
            text = "ThirdTabScreen"
        )
    }
}

@Preview
@Composable
fun PreThirdTabScreen() {
    ThirdTabScreen()
}

object ThirdScreenRoute {
    const val route = "ThirdScreen"
}

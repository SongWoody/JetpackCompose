package com.example.jetpackcompose.compose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.compose.navigation.MyNavHost
import com.example.jetpackcompose.compose.ui.ComposeTwoButtonDialog
import com.example.jetpackcompose.compose.ui.ComposeTwoButtonDialogInfo
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

@ExperimentalMaterial3Api
@Composable
fun MyComposeApp() {
    val navController = rememberNavController()

    var twoButtonDialogState: ComposeTwoButtonDialogInfo? by remember { mutableStateOf(null) }
    val onShowTwoButtonDialog: (ComposeTwoButtonDialogInfo)->Unit = {
        twoButtonDialogState = it
    }

    twoButtonDialogState?.let {
        ComposeTwoButtonDialog(it) {
            twoButtonDialogState = null
        }
    }

    JetpackComposeTheme {
        MyNavHost(
            navController = navController,
            onShowTwoButtonDialog = onShowTwoButtonDialog
        )
    }
}
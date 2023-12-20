package com.example.jetpackcompose.scenes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScene(modifier: Modifier, text: String = "", onValueChange: (String)->Unit) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "InputScene") })
    }) { paddingValues ->
        TextField(modifier = modifier.padding(paddingValues), value = text, onValueChange = onValueChange)
    }
}
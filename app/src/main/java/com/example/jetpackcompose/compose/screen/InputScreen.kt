package com.example.jetpackcompose.compose.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(modifier: Modifier, text: String = "", onValueChange: (String)->Unit) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "InputScreen") })
    }) { paddingValues ->
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {
            TextField(modifier = modifier.padding(paddingValues), value = text, onValueChange = onValueChange)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { }) {
                Text(text = "Submit")
            }
        }
    }
}
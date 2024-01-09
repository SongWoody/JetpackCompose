package com.example.jetpackcompose.compose.screen.fontsizechecker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@ExperimentalMaterial3Api
@Composable
fun FontSizeCheckerScreen(
    modifier: Modifier,
    welcomeText: String,
    onNavigateToInput: ()->Unit,
    viewModel: FontSizeCheckerViewModel = hiltViewModel()
) {
    val sliderPosition by viewModel.sp.collectAsState()

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "DemoScreen") })
    }) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            TargetText(message = welcomeText, fontSize = sliderPosition)

            Spacer(modifier = Modifier.height(150.dp))

            SizeSlider(sliderPosition = sliderPosition, onPositionChange = viewModel::changeSpValue)

            Text(
                style = MaterialTheme.typography.headlineMedium,
                text = "${sliderPosition.toInt()} sp"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = onNavigateToInput) {
                Text(text = "Navigate to InputButton")
            }
        }
    }
}


/**
 * Demo Text
 */
@Composable
fun TargetText(message: String, fontSize: Float) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
fun TargetTextPreView() {
    TargetText(message = "Welcome to Compose", fontSize = 16f)
}

@Composable
fun SizeSlider(sliderPosition: Float, onPositionChange: (Float)->Unit) {
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..40f,
        value = sliderPosition, onValueChange = onPositionChange)
}


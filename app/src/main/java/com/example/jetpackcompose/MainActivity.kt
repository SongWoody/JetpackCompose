package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

enum class Screens {
    Demo,
    Input,
}

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                val navController = rememberNavController()
                Scaffold(topBar = {
                    TopAppBar(title = { Text(text = "Title Bar") })
                }) { paddingValues ->
//                    DemoScreen(Modifier.padding(it))
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Demo.name
                    ) {
                        composable(Screens.Demo.name) {
                            DemoScreen(
                                modifier = Modifier.padding(paddingValues),
                                onNavigateToInput = {
                                    navController.navigate(Screens.Input.name)
                                }
                            )
                        }
                        composable(Screens.Input.name) {
                            InputScreen(modifier = Modifier.padding(paddingValues)) {

                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Demo Text
 */
@Composable
fun DemoText(message: String, fontSize: Float) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
fun DemoTextPreView() {
    DemoText(message = "Welcome to Compose", fontSize = 16f)
}

@Composable
fun DemoSlider(sliderPosition: Float, onPositionChange: (Float)->Unit) {
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..40f,
        value = sliderPosition, onValueChange = onPositionChange)
}

@Composable
fun DemoScreen(modifier: Modifier, onNavigateToInput: ()->Unit) {
    var sliderPosition by remember { mutableStateOf(20f) }

    val handlePositionChange = { position: Float ->
        sliderPosition = position
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize(),
    ) {
        DemoText(message = "Welcome to Compose", fontSize = sliderPosition)

        Spacer(modifier = Modifier.height(150.dp))

        DemoSlider(sliderPosition = sliderPosition, onPositionChange = handlePositionChange)

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(modifier: Modifier, text: String = "", onValueChange: (String)->Unit) {
    TextField(modifier = modifier,value = text, onValueChange = onValueChange)
}
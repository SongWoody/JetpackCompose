package com.example.jetpackcompose.compose.screen.colorchecker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.math.min

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorCheckerScreen(
    viewModel: ColorCheckerViewModel = viewModel()
) {
    Scaffold { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(paddingValues)
        ) {
            val colorRedValue by viewModel.colorRed.collectAsState()
            val colorGreenValue by viewModel.colorGreen.collectAsState()
            val colorBlueValue by viewModel.colorBlue.collectAsState()

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .weight(1f)
                .background(
                    Color(
                        red = if (colorRedValue == 0f) 0f else min(colorRedValue / 255f, 1f),
                        green = if (colorGreenValue == 0f) 0f else min(colorGreenValue / 255f, 1f),
                        blue = if (colorBlueValue == 0f) 0f else min(colorBlueValue / 255f, 1f)
                    )
                )) {

            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.White)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Red Color")
                NumberView(v = colorRedValue, onValueChange = viewModel::updateColorRed)
                
                Text(text = "Green Color")
                NumberView(v = colorGreenValue, onValueChange = viewModel::updateColorGreen)
                
                Text(text = "Blue Color")
                NumberView(v = colorBlueValue, onValueChange = viewModel::updateColorBlue)
            }
        }
    }
}

@Composable
fun NumberView(v: Float, onValueChange: (Float)->Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Slider(
            modifier = Modifier.padding(end = 10.dp).weight(0.5f),
            valueRange = 0f..255f,
            value = v, onValueChange = onValueChange)

        BasicTextField(
            modifier = Modifier.width(30.dp),
            value = v.toString(),
            onValueChange = {
                onValueChange(it.toFloat())
            }
        ) {
            Text(text = "${v.toInt()}")
        }
    }
}
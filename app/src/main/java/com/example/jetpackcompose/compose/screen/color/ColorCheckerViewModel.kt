package com.example.jetpackcompose.compose.screen.color

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ColorCheckerViewModel : ViewModel() {

    private val _colorRed = MutableStateFlow(255f)
    val colorRed = _colorRed.asStateFlow()

    private val _colorGreen = MutableStateFlow(255f)
    val colorGreen = _colorGreen.asStateFlow()

    private val _colorBlue = MutableStateFlow(255f)
    val colorBlue = _colorBlue.asStateFlow()

    fun updateColorRed(v: Float) {
        _colorRed.value = v
    }

    fun updateColorGreen(v: Float) {
        _colorGreen.value = v
    }

    fun updateColorBlue(v: Float) {
        _colorBlue.value = v
    }
}
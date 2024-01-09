package com.example.jetpackcompose.compose.screen.colorchecker

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ColorCheckerViewModel @Inject constructor() : ViewModel() {

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
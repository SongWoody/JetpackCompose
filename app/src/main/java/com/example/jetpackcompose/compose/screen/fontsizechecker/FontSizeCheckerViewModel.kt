package com.example.jetpackcompose.compose.screen.fontsizechecker

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FontSizeCheckerViewModel @Inject constructor() : ViewModel() {
    private val _sp = MutableStateFlow(20f)
    val sp: StateFlow<Float> = _sp

    /**
     * sp 값 변경
     */
    fun changeSpValue(sp: Float) {
        _sp.value = sp
    }
}
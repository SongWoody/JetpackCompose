package com.example.jetpackcompose.compose.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DemoScreenViewModel : ViewModel() {

    class Factory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return DemoScreenViewModel() as T
        }
    }

    private val _sp = MutableStateFlow(20f)
    val sp: StateFlow<Float> = _sp

    /**
     * sp 값 변경
     */
    fun changeSpValue(sp: Float) {
        _sp.value = sp
    }
}
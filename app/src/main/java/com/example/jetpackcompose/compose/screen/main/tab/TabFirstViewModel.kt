package com.example.jetpackcompose.compose.screen.main.tab

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class TabFirstViewModel: ViewModel() {
    data class MenuItem(
        val title: String
    )

    val menuItems: MutableStateFlow<List<MenuItem>> = MutableStateFlow(
        listOf(
            MenuItem("HIHI"),
            MenuItem("Hello"),
        )
    )
}
package com.example.jetpackcompose.compose.screen.main.tab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.compose.screen.colorchecker.ColorCheckerRoute
import com.example.jetpackcompose.compose.screen.fontsizechecker.FontCheckerRoute
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class TabFirstViewModel: ViewModel() {
    data class MenuItem(
        val title: String,
        val onClickAction: ()->Unit = {}
    )

    private val _navigateRoute = MutableSharedFlow<String>()
    val navigateRoute = _navigateRoute.asSharedFlow()

    val menuItems: MutableStateFlow<List<MenuItem>> = MutableStateFlow(
        listOf(
            MenuItem("ColorChecker", onClickAction = {
                viewModelScope.launch { _navigateRoute.emit(ColorCheckerRoute.route) }
            }),
            MenuItem("FontChecker", onClickAction = {
                viewModelScope.launch { _navigateRoute.emit(FontCheckerRoute.route) }
            }),
        )
    )
}
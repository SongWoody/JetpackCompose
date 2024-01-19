package com.example.jetpackcompose.compose.etc

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource

/**
 * ViewModel 에서 View 로 String, @StringRes Int 전달을 위해 사용
 */
class TextResource {
    private val text: String
    @StringRes
    private val textResId: Int?

    constructor(text: String) {
        this.text = text
        this.textResId = null
    }

    constructor(@StringRes textRes: Int) {
        this.text = ""
        this.textResId = textRes
    }
    @Composable
    @ReadOnlyComposable
    fun getString(): String {
        return if (textResId != null) stringResource(id = textResId) else text
    }
}
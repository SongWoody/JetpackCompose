package com.example.jetpackcompose.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


typealias DismissRequest = () -> Unit
data class ComposeTwoButtonDialogInfo(
    val title: String,
    val onLeftButtonClick: (DismissRequest)->Unit,
    val onRightButtonClick: (DismissRequest)->Unit
)

/**
 * Compose Common Dialog
 */
@Composable
fun ComposeTwoButtonDialog(
    twoButtonDialogInfo: ComposeTwoButtonDialogInfo,
    onDismissRequest: ()->Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Column(
            Modifier
                .background(Color.White)
                .padding(horizontal = 26.dp),
        ) {
            Column(
                modifier = Modifier.padding(vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = twoButtonDialogInfo.title)
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp, bottom = 15.dp)
                    .height(47.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                // Left Button
                Button(
                    modifier = Modifier
                        .width(124.dp)
                        .fillMaxSize(),
                    onClick = { twoButtonDialogInfo.onLeftButtonClick(onDismissRequest) }) {
                    Text("취소")
                }
                Spacer(modifier = Modifier.width(11.dp))
                // Right Button
                Button(
                    modifier = Modifier
                        .width(124.dp)
                        .fillMaxSize(),
                    onClick = { twoButtonDialogInfo.onRightButtonClick(onDismissRequest) }) {
                    Text(text = "확인")
                }
            }
        }
    }
}

@Preview(device = "spec:width=360dp,height=640dp")
@Composable
fun PreviewComposeTwoButtonDialog() {
    ComposeTwoButtonDialog(
        twoButtonDialogInfo = ComposeTwoButtonDialogInfo("Hello World!", {}, {}),
        onDismissRequest = {}
    )
}
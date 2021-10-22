package com.nahidalgo.composeexample.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable

@Composable
fun SendMessageBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSendMessage: () -> Unit
) {
    Row {
       TextField(value = text, onValueChange = onTextChange)
       IconButton(onClick = onSendMessage) {
           Icon(imageVector = Icons.Filled.Send, "Send message")
       } 
    }
}
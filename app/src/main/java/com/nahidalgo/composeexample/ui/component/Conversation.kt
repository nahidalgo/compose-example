package com.nahidalgo.composeexample.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.nahidalgo.composeexample.domain.model.Message
import com.nahidalgo.composeexample.ui.viewmodel.MessagesViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

@Composable
fun MessagesScreen(
    messagesViewModel: MessagesViewModel
) {
    val uiState by messagesViewModel.uiState.collectAsState()
    val nameState by messagesViewModel.nameState.collectAsState()

    if (uiState.loading) {
        CircularProgressIndicator()
    } else {
        Column {
            Conversation(
                messages = uiState.messages,
                modifier = Modifier.fillMaxHeight(0.8f)
            )
            SendMessageBar(
                text = nameState,
                onTextChange = { messagesViewModel.onNameChange(it) },
                onSendMessage = { messagesViewModel.sendMessage() }
            )
        }
    }
}

@Composable
fun Conversation(
    messages: List<Message>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}
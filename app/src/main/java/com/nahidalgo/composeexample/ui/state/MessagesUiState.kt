package com.nahidalgo.composeexample.ui.state

import com.nahidalgo.composeexample.domain.model.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MessagesUiState(
    val messages: List<Message> = emptyList(),
    val loading: Boolean = false,
    val error: Boolean = false
)
package com.nahidalgo.composeexample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nahidalgo.composeexample.domain.model.Message
import com.nahidalgo.composeexample.domain.repository.MessageRepository
import com.nahidalgo.composeexample.ui.state.MessagesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class MessagesViewModel(
    private val messageRepository: MessageRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MessagesUiState(loading = false))
    val uiState: StateFlow<MessagesUiState> = _uiState

    private val _nameState = MutableStateFlow("")
    val nameState: StateFlow<String> = _nameState

    fun sendMessage() {
        _uiState.value = MessagesUiState(loading = true, messages = _uiState.value.messages)
        viewModelScope.launch {
            messageRepository.getMessagesAsFlow(_nameState.value).collect { message ->
                val prevMessages = _uiState.value.messages
                _uiState.value = MessagesUiState(loading = false, messages = prevMessages + message)
            }
        }
    }

    fun onNameChange(name: String) {
        _nameState.value = name
    }

}
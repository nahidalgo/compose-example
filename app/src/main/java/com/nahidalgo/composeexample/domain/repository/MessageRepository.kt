package com.nahidalgo.composeexample.domain.repository

import com.nahidalgo.composeexample.domain.datasource.GreeterServiceGrpcDataSource
import com.nahidalgo.composeexample.domain.model.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

interface MessageRepository {
    suspend fun getMessagesAsFlow(name: String) : Flow<Message>
}

class MessageRepositoryImpl(
    private val greeterServiceGrpcDataSource: GreeterServiceGrpcDataSource
) : MessageRepository {

    override suspend fun getMessagesAsFlow(name: String) : Flow<Message> {

        return greeterServiceGrpcDataSource.sayStreamHelloByName(name).transform { message ->
            run {
                emit(Message("Server", message))
            }
        }
    }
}
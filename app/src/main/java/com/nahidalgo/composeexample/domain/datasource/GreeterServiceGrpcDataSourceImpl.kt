package com.nahidalgo.composeexample.domain.datasource

import com.nahidalgo.composeexample.domain.service.GreeterServiceClient
import kotlinx.coroutines.flow.Flow

interface GreeterServiceGrpcDataSource {
    suspend fun sayStreamHelloByName(name: String) : Flow<String>
}

class GreeterServiceGrpcDataSourceImpl(
    private val greeterServiceClient: GreeterServiceClient
) : GreeterServiceGrpcDataSource {

    override suspend fun sayStreamHelloByName(name: String) : Flow<String> {
        return greeterServiceClient.sayStreamHello(name)
    }

}
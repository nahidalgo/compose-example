package com.nahidalgo.composeexample.domain.service

import com.nahidalgo.composeexample.network.grpc.GrpcChannelProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import proto.greeter.v1.Greeter
import proto.greeter.v1.GreeterServiceGrpcKt

interface GreeterServiceClient {
    suspend fun sayStreamHello(name: String): Flow<String>
}

class GreeterServiceClienteImpl(
    private val channelProvider: GrpcChannelProvider
) : GreeterServiceClient {

    override suspend fun sayStreamHello(name: String): Flow<String> {
        return try {
            val stub = GreeterServiceGrpcKt.GreeterServiceCoroutineStub(channelProvider.channel())
            val request = Greeter.HelloRequest.newBuilder().setName(name).build()
            stub.sayStreamHello(request).transform { reply ->
                emit(reply.message)
            }
        } catch (t: Throwable) {
            emptyFlow()
        }
    }
}
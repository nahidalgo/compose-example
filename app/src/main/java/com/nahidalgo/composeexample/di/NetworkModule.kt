package com.nahidalgo.composeexample.di

import com.nahidalgo.composeexample.network.grpc.GrpcAndroidChannelProvider
import com.nahidalgo.composeexample.network.grpc.GrpcChannelProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object NetworkModule {
    const val PROPERTY_GRPC_SERVER_ADDRESS_KEY = "grpcServerAddress"
    const val PROPERTY_GRPC_SERVER_PORT_KEY = "grpcServerPort"

    val module = module {
        single<GrpcChannelProvider> {
            GrpcAndroidChannelProvider(
                androidContext(),
                getProperty(PROPERTY_GRPC_SERVER_ADDRESS_KEY),
                getProperty(PROPERTY_GRPC_SERVER_PORT_KEY).toInt()
            )
        }
    }
}
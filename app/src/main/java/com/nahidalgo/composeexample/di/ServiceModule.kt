package com.nahidalgo.composeexample.di

import com.nahidalgo.composeexample.domain.service.GreeterServiceClient
import com.nahidalgo.composeexample.domain.service.GreeterServiceClienteImpl
import org.koin.dsl.module

object ServiceModule {

    val module = module {
        factory<GreeterServiceClient> { GreeterServiceClienteImpl(get()) }
    }
}
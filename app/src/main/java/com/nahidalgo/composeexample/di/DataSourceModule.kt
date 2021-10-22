package com.nahidalgo.composeexample.di

import com.nahidalgo.composeexample.domain.datasource.GreeterServiceGrpcDataSource
import com.nahidalgo.composeexample.domain.datasource.GreeterServiceGrpcDataSourceImpl
import org.koin.dsl.module

object DataSourceModule {

    val module = module {
        factory<GreeterServiceGrpcDataSource> { GreeterServiceGrpcDataSourceImpl(get()) }
    }
}
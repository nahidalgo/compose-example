package com.nahidalgo.composeexample.di

import com.nahidalgo.composeexample.domain.repository.MessageRepository
import com.nahidalgo.composeexample.domain.repository.MessageRepositoryImpl
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        factory<MessageRepository> { MessageRepositoryImpl(get()) }
    }
}
package com.nahidalgo.composeexample.di

import com.nahidalgo.composeexample.ui.viewmodel.MessagesViewModel
import org.koin.dsl.module

object ViewModelModule {
    val module = module {
        factory { MessagesViewModel(get()) }
    }
}
package com.nahidalgo.composeexample

import android.app.Application
import com.nahidalgo.composeexample.di.DataSourceModule
import com.nahidalgo.composeexample.di.NetworkModule
import com.nahidalgo.composeexample.di.RepositoryModule
import com.nahidalgo.composeexample.di.ServiceModule
import com.nahidalgo.composeexample.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.fileProperties

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                ViewModelModule.module,
                NetworkModule.module,
                ServiceModule.module,
                DataSourceModule.module,
                RepositoryModule.module
            )
            fileProperties()
        }
    }
}
package com.parithi.paintora

import android.app.Application
import com.parithi.paintora.di.appModule
import org.koin.core.context.startKoin

class PaintoraApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(appModule)
        }
    }

}
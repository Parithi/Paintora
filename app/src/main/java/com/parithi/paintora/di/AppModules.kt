package com.parithi.paintora.di

import com.parithi.paintora.contracts.HomeContract
import com.parithi.paintora.helpers.PaintingDataProvider
import com.parithi.paintora.helpers.PaintingDataProvider_Local
import com.parithi.paintora.presenters.HomePresenter
import com.parithi.paintora.repository.Repository
import org.koin.dsl.module

val appModule = module {

    single<PaintingDataProvider> { PaintingDataProvider_Local() }
    single { Repository(get()) }

    factory { (view: HomeContract.View) -> HomePresenter(view,get()) }

}
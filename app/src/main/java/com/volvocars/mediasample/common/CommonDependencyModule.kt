package com.volvocars.mediasample.common

import com.volvocars.mediasample.common.util.ResourceUriUtil
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object CommonDependencyModule {
    fun dependencies() = module {
        single { ResourceUriUtil(context = androidApplication()) }
    }
}

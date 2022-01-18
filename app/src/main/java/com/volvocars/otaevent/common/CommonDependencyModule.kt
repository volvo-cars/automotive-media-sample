package com.volvocars.otaevent.common

import com.volvocars.otaevent.common.util.ResourceUriUtil
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object CommonDependencyModule {
    fun dependencies() = module {
        single { ResourceUriUtil(context = androidApplication()) }
    }
}

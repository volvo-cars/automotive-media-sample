package com.volvocars.otaevent.common

import android.app.Application
import com.volvocars.otaevent.dataaccess.DataAccessDependencyModule
import com.volvocars.otaevent.mediaplayback.PlaybackDependencyModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

object DependencyBootstrapper {

    fun bootstrap(application: Application) {
        startKoin {
            androidContext(application)
            modules(dependencyModules())
        }
    }

    private fun dependencyModules() = listOf(
        CommonDependencyModule.dependencies(),
        DataAccessDependencyModule.dependencies(),
        PlaybackDependencyModule.dependencies()
    )
}

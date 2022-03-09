package com.volvocars.mediasample.common

import android.app.Application
import com.volvocars.mediasample.dataaccess.DataAccessDependencyModule
import com.volvocars.mediasample.mediaplayback.PlaybackDependencyModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

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

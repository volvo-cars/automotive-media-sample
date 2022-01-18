package com.volvocars.otaevent

import android.app.Application
import com.volvocars.otaevent.common.DependencyBootstrapper

class MediaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DependencyBootstrapper.bootstrap(this)
    }
}

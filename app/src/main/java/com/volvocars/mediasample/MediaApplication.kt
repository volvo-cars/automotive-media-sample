package com.volvocars.mediasample

import android.app.Application
import com.volvocars.mediasample.common.DependencyBootstrapper

class MediaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DependencyBootstrapper.bootstrap(this)
    }
}

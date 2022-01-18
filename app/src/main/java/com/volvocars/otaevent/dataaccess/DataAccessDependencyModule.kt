package com.volvocars.otaevent.dataaccess

import com.volvocars.otaevent.domain.SongRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object DataAccessDependencyModule {
    fun dependencies() = module {
        factory {
            PlaylistFactory(context = androidApplication(), resourceUriUtil = get())
        }

        single<SongRepository> { SongRepositoryImpl(playlistFactory = get()) }
    }
}
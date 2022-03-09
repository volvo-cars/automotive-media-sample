package com.volvocars.mediasample.mediaplayback

import android.content.Context
import android.support.v4.media.session.MediaSessionCompat
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object PlaybackDependencyModule {
    fun dependencies() = module {
        factory { MediaItemFactory(context = androidApplication()) }
        single { MediaLibrary(mediaItemFactory = get(), songRepository = get()) }

        factory {
            AudioAttributes.Builder()
                .setContentType(C.CONTENT_TYPE_MUSIC)
                .setUsage(C.USAGE_MEDIA)
                .build()
        }

        factory<Player> { (serviceContext : Context) ->
            val audioAttributes = get<AudioAttributes>()
            SimpleExoPlayer.Builder(serviceContext).build().apply {
                setAudioAttributes(audioAttributes, true)
            }
        }

        factory { (serviceContext : Context) ->
            MediaSessionCompat(serviceContext, "MusicService")
        }
    }
}
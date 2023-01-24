/*
 * Copyright 2022 Volvo Car Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
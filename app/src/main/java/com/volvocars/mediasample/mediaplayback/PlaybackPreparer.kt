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

import android.net.Uri
import android.os.Bundle
import android.os.ResultReceiver
import android.support.v4.media.session.PlaybackStateCompat
import com.google.android.exoplayer2.ControlDispatcher
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.volvocars.mediasample.common.logging.logd
import com.volvocars.mediasample.common.logging.loge

class PlaybackPreparer(
    private val player: Player,
    private val mediaLibrary: MediaLibrary
) : MediaSessionConnector.PlaybackPreparer {
    override fun onCommand(
        player: Player,
        controlDispatcher: ControlDispatcher,
        command: String,
        extras: Bundle?,
        cb: ResultReceiver?
    ) = false

    override fun getSupportedPrepareActions() =
            PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID or
            PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID or
            PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH or
            PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH

    override fun onPrepare(playWhenReady: Boolean) {
        logd("prepare - play: $playWhenReady")
        player.playWhenReady = playWhenReady
        player.stop()
        player.prepare()
    }

    override fun onPrepareFromMediaId(mediaId: String, playWhenReady: Boolean, extras: Bundle?) {
        val playableMedia = mediaLibrary.getSongById(mediaId)?.toExoMediaItem()
        if (playableMedia == null) {
            loge("Media not found.")
            return
        }
        logd(playableMedia.mediaMetadata.title.toString())
        player.playWhenReady = playWhenReady
        player.stop()
        player.setMediaItem(playableMedia)
        player.prepare()
    }

    override fun onPrepareFromSearch(query: String, playWhenReady: Boolean, extras: Bundle?) {
        onPrepare(playWhenReady)
    }

    override fun onPrepareFromUri(uri: Uri, playWhenReady: Boolean, extras: Bundle?) {
        onPrepare(playWhenReady)
    }
}

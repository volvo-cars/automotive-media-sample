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
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import com.google.android.exoplayer2.MediaItem
import com.volvocars.mediasample.R
import com.volvocars.mediasample.domain.Song

class MediaItemFactory(private val context: Context) {
    fun createBrowsableRootMediaItem(rootId: String): MediaMetadataCompat =
            MediaMetadataCompat.Builder().apply {
                id = rootId
                title = context.getString(R.string.browsable_tab_label)
                flag = MediaBrowserCompat.MediaItem.FLAG_BROWSABLE
            }.build()

    fun createPlayableMediaItem(song: Song, playlistSize: Int, songNumber: Int): MediaMetadataCompat =
            MediaMetadataCompat.Builder().apply {
                id = song.id
                title = song.title
                mediaUri = song.mediaUri
                artist = song.artist
                albumArtUri = song.mediaArtUri
                numberOfTracks = playlistSize.toLong()
                trackNumber = songNumber.toLong()
                flag = MediaBrowserCompat.MediaItem.FLAG_PLAYABLE

                displayTitle = song.title
                displaySubtitle = song.subtitle
                displayDescription = song.description
                displayIconUri = song.mediaArtUri
            }.build()
}

fun MediaMetadataCompat.toExoMediaItem() = MediaItem.Builder()
        .setUri(mediaUri)
        .build()

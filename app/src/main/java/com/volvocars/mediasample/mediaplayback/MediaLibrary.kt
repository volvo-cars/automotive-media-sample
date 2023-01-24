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

import android.support.v4.media.MediaMetadataCompat
import com.volvocars.mediasample.common.logging.logd
import com.volvocars.mediasample.domain.Playlist
import com.volvocars.mediasample.domain.SongRepository

/**
 * Represents the library to browse media in. The structure is as follows:
 * [Root/]: Playlist Root
 *    |
 *    |__ Song 1
 *    |
 *    |__ Song 2
 */
class MediaLibrary(mediaItemFactory: MediaItemFactory, songRepository: SongRepository) {
    private val playlist: Playlist = songRepository.retrievePlaylist()
    private val library = mutableMapOf<String, List<MediaMetadataCompat>>()

    init {
        library[BROWSABLE_ROOT_ID] = listOf(
            mediaItemFactory.createBrowsableRootMediaItem(playlist.id)
        )
        library[playlist.id] = playlist.songs.mapIndexed { songIndex, song ->
            mediaItemFactory.createPlayableMediaItem(
                song = song,
                playlistSize = playlist.songs.size,
                songNumber = songIndex + 1
            )
        }
    }

    fun getPlaylistById(id: String): List<MediaMetadataCompat>? {
        logd("need $id")
        return library[id]
    }

    fun getSongById(id: String): MediaMetadataCompat? {
        return library[playlist.id]?.find { it.id == id }
    }
}

const val BROWSABLE_ROOT_ID = "root/"

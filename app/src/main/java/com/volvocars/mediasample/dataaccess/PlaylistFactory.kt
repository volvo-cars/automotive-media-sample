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
package com.volvocars.mediasample.dataaccess

import android.content.Context
import com.volvocars.mediasample.R
import com.volvocars.mediasample.common.util.ResourceUriUtil
import com.volvocars.mediasample.domain.Playlist
import com.volvocars.mediasample.domain.Song

private const val PLAYLIST_ID = "volvo-pre-listen-playlist-id"

class PlaylistFactory(
    private val context: Context,
    private val resourceUriUtil: ResourceUriUtil
) {
    fun createPlaylist() = Playlist(
        id = PLAYLIST_ID,
        songs = getSongs(),
    )

    private fun getSongs() = listOf(
        Song(
            id = "premier_song_id",
            title = context.getString(R.string.sample_song_title),
            subtitle = context.getString(R.string.sample_song_subtitle),
            description = context.getString(R.string.sample_song_description),
            mediaArtUri = resourceUriUtil.getUriFor(R.drawable.abba_album_art).toString(),
            mediaUri = resourceUriUtil.getUriFor(R.raw.test_audio_track).toString(),
            artist = context.getString(R.string.sample_artist_name),
        )
    )
}

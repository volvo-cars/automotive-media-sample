package com.volvocars.otaevent.dataaccess

import android.content.Context
import com.volvocars.otaevent.R
import com.volvocars.otaevent.common.util.ResourceUriUtil
import com.volvocars.otaevent.domain.Playlist
import com.volvocars.otaevent.domain.Song

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
            title = context.getString(R.string.abba_premier_song_title),
            subtitle = context.getString(R.string.abba_premier_song_subtitle),
            description = context.getString(R.string.abba_premier_song_description),
            mediaArtUri = resourceUriUtil.getUriFor(R.drawable.abba_album_art).toString(),
            mediaUri = resourceUriUtil.getUriFor(R.raw.test_audio_track).toString(),
            artist = context.getString(R.string.premier_song_artist_name),
        )
    )
}

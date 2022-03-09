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

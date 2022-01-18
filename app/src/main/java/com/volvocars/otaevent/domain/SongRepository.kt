package com.volvocars.otaevent.domain

interface SongRepository {
    fun retrievePlaylist(): Playlist
}

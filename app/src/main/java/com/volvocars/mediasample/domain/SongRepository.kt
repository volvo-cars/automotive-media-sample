package com.volvocars.mediasample.domain

interface SongRepository {
    fun retrievePlaylist(): Playlist
}

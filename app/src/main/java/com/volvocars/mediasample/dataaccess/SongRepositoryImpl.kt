package com.volvocars.mediasample.dataaccess

import com.volvocars.mediasample.domain.SongRepository

class SongRepositoryImpl(private val playlistFactory: PlaylistFactory) : SongRepository {
    override fun retrievePlaylist() = playlistFactory.createPlaylist()
}

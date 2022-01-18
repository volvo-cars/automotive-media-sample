package com.volvocars.otaevent.dataaccess

import com.volvocars.otaevent.domain.SongRepository

class SongRepositoryImpl(private val playlistFactory: PlaylistFactory) : SongRepository {
    override fun retrievePlaylist() = playlistFactory.createPlaylist()
}

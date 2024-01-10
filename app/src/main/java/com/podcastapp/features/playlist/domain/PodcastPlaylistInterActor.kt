package com.podcastapp.features.playlist.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PodcastPlaylistInterActor @Inject constructor(
    private val repository: PodcastPlaylistRepository
) {
    fun getPlaylist(): Flow<PlayList> {
        return repository.getPlaylist()
    }
}
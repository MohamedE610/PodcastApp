package com.podcastapp.features.playlist.domain

import kotlinx.coroutines.flow.Flow


interface PodcastPlaylistRepository {
    fun getPlaylist(): Flow<PlayList>
}
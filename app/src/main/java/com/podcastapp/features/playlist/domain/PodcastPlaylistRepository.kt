package com.podcastapp.features.playlist.domain

import kotlinx.coroutines.flow.Flow


interface PodcastPlaylistRepository {
    suspend fun getPlaylist(): Flow<PlayList>
}
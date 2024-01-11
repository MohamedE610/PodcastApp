package com.podcastapp.features.playlist.presentation

import com.podcastapp.features.playlist.domain.PlayListInfo

data class PlaylistUI(
    val info: PlayListInfo,
    val episodes: List<EpisodeUI>
)

data class EpisodeUI(
    val id: String,
    val state: MediaState,
    val name: String,
    val desc: String,
    val image: String,
    val audioLink: String,
    val durationInSeconds: Long,
    val podcastName: String,
    val releaseDate: String,
    val createdAt: String,
    val updatedAt: String,
    val position: Int
)

sealed class MediaState {
    data object Idle : MediaState()
    data object Loading : MediaState()
    data class Play(val currentPosition: Long) : MediaState()
    data class Pause(val currentPosition: Long) : MediaState()
}
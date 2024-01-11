package com.podcastapp.features.playlist.presentation

import com.podcastapp.features.playlist.domain.Episode
import com.podcastapp.features.playlist.domain.PlayList

fun PlayList.map(): PlaylistUI {
    return PlaylistUI(
        info = info,
        episodes = episodes.map { it.map() }
    )
}

fun Episode.map(): EpisodeUI {
    return EpisodeUI(
        id = id,
        state = MediaState.Idle,
        isLoading = false,
        name = name,
        desc = desc,
        image = image,
        audioLink = audioLink,
        durationInSeconds = durationInSeconds,
        podcastName = podcastName,
        releaseDate = releaseDate,
        createdAt = createdAt,
        updatedAt = updatedAt,
        position = position
    )
}
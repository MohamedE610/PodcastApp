package com.podcastapp.features.playlist.data.source

import com.podcastapp.features.playlist.data.EpisodeData
import com.podcastapp.features.playlist.data.PlayListInfoData
import com.podcastapp.features.playlist.data.PlayListResponse
import com.podcastapp.features.playlist.domain.Episode
import com.podcastapp.features.playlist.domain.PlayList
import com.podcastapp.features.playlist.domain.PlayListInfo

fun PlayListResponse.map(): PlayList {
    val info = data.playlist.map()
    val episodes = data.episodes.map { it.map() }
    return PlayList(info = info, episodes = episodes)
}

fun PlayListInfoData.map(): PlayListInfo {
    return PlayListInfo(
        id = id,
        type = type,
        name = name,
        desc = desc,
        image = image,
        episodeCount = episodeCount,
        episodeTotalDuration = episodeTotalDuration,
        createdAt = createdAt,
        updatedAt = updatedAt,
        followingCount = followingCount,
        userId = userId
    )
}

private fun EpisodeData.map(): Episode {
    return Episode(
        id = id,
        name = name,
        desc = desc,
        image = image,
        audioLink = audioLink,
        durationInSeconds = durationInSeconds,
        views = views,
        podcastItunesId = podcastItunesId,
        podcastName = podcastName,
        releaseDate = releaseDate,
        createdAt = createdAt,
        updatedAt = updatedAt,
        isEditorPick = isEditorPick,
        position = position
    )
}
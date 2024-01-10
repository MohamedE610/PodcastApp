package com.podcastapp.features.playlist.domain

data class PlayList(
    val info: PlayListInfo,
    val episodes: List<Episode>
)

data class PlayListInfo(
    val id: String,
    val type: String,
    val name: String,
    val desc: String,
    val image: String,
    val episodeCount: Int,
    val episodeTotalDuration: Long,
    val createdAt: String,
    val updatedAt: String,
    val followingCount: Int,
    val userId: String
)

data class Episode(
    val id: String,
    val name: String,
    val desc: String,
    val image: String,
    val audioLink: String,
    val durationInSeconds: Long,
    val views: Int,
    val podcastItunesId: String,
    val podcastName: String,
    val releaseDate: String,
    val createdAt: String,
    val updatedAt: String,
    val isEditorPick: Boolean,
    val position: Int
)

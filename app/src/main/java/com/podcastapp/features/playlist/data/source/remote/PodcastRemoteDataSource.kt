package com.podcastapp.features.playlist.data.source.remote

import com.podcastapp.features.playlist.data.PlayListResponse
import com.podcastapp.features.playlist.data.UserToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PodcastRemoteDataSource @Inject constructor(private val api: PodcastApi) {
    fun login(): Flow<UserToken> = flow { api.login() }

    fun getPlaylist(token: String): Flow<PlayListResponse> = flow {
        api.getPlayList(BEARER_PREFIX.plus(token))
    }
}

private const val BEARER_PREFIX = "Bearer "
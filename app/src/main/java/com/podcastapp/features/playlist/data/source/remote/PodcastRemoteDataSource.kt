package com.podcastapp.features.playlist.data.source.remote

import com.podcastapp.core.extension.emitFlow
import com.podcastapp.features.playlist.data.PlayListResponse
import com.podcastapp.features.playlist.data.UserToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PodcastRemoteDataSource @Inject constructor(private val api: PodcastApi) {
    suspend fun login(): Flow<UserToken> = emitFlow { api.login() }

    suspend fun getPlaylist(token: String): Flow<PlayListResponse> = emitFlow {
        api.getPlayList(BEARER_PREFIX.plus(token))
    }
}

private const val BEARER_PREFIX = "Bearer "
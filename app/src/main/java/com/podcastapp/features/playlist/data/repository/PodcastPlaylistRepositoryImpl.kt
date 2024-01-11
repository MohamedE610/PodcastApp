package com.podcastapp.features.playlist.data.repository

import com.podcastapp.core.extension.flatMapFlow
import com.podcastapp.features.playlist.data.source.map
import com.podcastapp.features.playlist.data.source.remote.PodcastRemoteDataSource
import com.podcastapp.features.playlist.domain.PlayList
import com.podcastapp.features.playlist.domain.PodcastPlaylistRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PodcastPlaylistRepositoryImpl @Inject constructor(
    private val remoteDataSource: PodcastRemoteDataSource
) : PodcastPlaylistRepository {
    override suspend fun getPlaylist(): Flow<PlayList> {
        return remoteDataSource.login()
            .flatMapFlow {
                remoteDataSource.getPlaylist(it.accessToken)
            }
            .map { it.map() }
    }

}
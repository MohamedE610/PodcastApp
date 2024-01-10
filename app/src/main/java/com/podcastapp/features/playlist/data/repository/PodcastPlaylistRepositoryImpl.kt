package com.podcastapp.features.playlist.data.repository

import com.podcastapp.features.playlist.data.source.map
import com.podcastapp.features.playlist.data.source.remote.PodcastRemoteDataSource
import com.podcastapp.features.playlist.domain.PlayList
import com.podcastapp.features.playlist.domain.PodcastPlaylistRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PodcastPlaylistRepositoryImpl @Inject constructor(
    private val remoteDataSource: PodcastRemoteDataSource
) : PodcastPlaylistRepository {
    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getPlaylist(): Flow<PlayList> {
        return remoteDataSource.login()
            .flatMapConcat { remoteDataSource.getPlaylist(it.accessToken) }
            .map { it.map() }
    }

}
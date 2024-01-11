package com.podcastapp.features.playlist.data.repository

import com.podcastapp.core.extension.emitFlow
import com.podcastapp.features.playlist.data.UserToken
import com.podcastapp.features.playlist.data.getMockedPlaylistResponse
import com.podcastapp.features.playlist.data.source.map
import com.podcastapp.features.playlist.data.source.remote.PodcastRemoteDataSource
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class PodcastPlaylistRepositoryImplTest {
    @Test
    fun `given getPlaylist() is called, when data loaded, then return playlist entity`() =
        runTest {
            //arrange
            val token = "access_token"
            val userToken = mock(UserToken::class.java)
            val mockResponse = getMockedPlaylistResponse()
            val expected = mockResponse.map()
            val remoteDataSource = mock(PodcastRemoteDataSource::class.java)
            val repository = PodcastPlaylistRepositoryImpl(remoteDataSource)

            `when`(userToken.accessToken)
                .thenReturn(token)

            `when`(remoteDataSource.login())
                .thenReturn(emitFlow { userToken })

            `when`(remoteDataSource.getPlaylist(token = anyString()))
                .thenReturn(emitFlow { mockResponse })

            //act
            val result = repository.getPlaylist().singleOrNull()

            //assert
            Assert.assertEquals(expected, result)
        }

    @Test(expected = Throwable::class)
    fun `given getPlaylist() is called, when data loading fail, then return error`() =
        runTest {
            //arrange
            val token = "access_token"
            val userToken = mock(UserToken::class.java)
            val remoteDataSource = mock(PodcastRemoteDataSource::class.java)
            val repository = PodcastPlaylistRepositoryImpl(remoteDataSource)

            `when`(userToken.accessToken)
                .thenReturn(token)

            `when`(remoteDataSource.login())
                .thenReturn(emitFlow { userToken })

            `when`(remoteDataSource.getPlaylist(token = anyString()))
                .thenThrow(Throwable())

            //act
            repository.getPlaylist().singleOrNull()
        }

    @Test(expected = Throwable::class)
    fun `given getPlaylist() is called, when login failed, then return error`() =
        runTest {
            //arrange
            val mockResponse = getMockedPlaylistResponse()
            val remoteDataSource = mock(PodcastRemoteDataSource::class.java)
            val repository = PodcastPlaylistRepositoryImpl(remoteDataSource)

            `when`(remoteDataSource.login())
                .thenThrow(Throwable())

            `when`(remoteDataSource.getPlaylist(token = anyString()))
                .thenReturn(emitFlow { mockResponse })

            //act
            repository.getPlaylist().singleOrNull()
        }
}
package com.podcastapp.features.playlist.domain

import com.podcastapp.core.extension.emitFlow
import com.podcastapp.features.playlist.data.getMockedPlaylistResponse
import com.podcastapp.features.playlist.data.repository.PodcastPlaylistRepositoryImpl
import com.podcastapp.features.playlist.data.source.map
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class PodcastPlaylistInterActorTest {
    @Test
    fun `given getPlaylist() is called, when data loaded, then return playlist entity`() =
        runTest {
            //arrange
            val mockResponse = getMockedPlaylistResponse()
            val expected = mockResponse.map()
            val repository = mock(PodcastPlaylistRepositoryImpl::class.java)
            val interActor = PodcastPlaylistInterActor(repository)

            `when`(repository.getPlaylist())
                .thenReturn(emitFlow { expected })

            //act
            val result = interActor.getPlaylist().singleOrNull()

            //assert
            assertEquals(expected, result)
        }

    @Test(expected = Throwable::class)
    fun `given getPlaylist() is called, when data loading fail, then return error`() =
        runTest {
            //arrange
            val repository = mock(PodcastPlaylistRepositoryImpl::class.java)
            val interActor = PodcastPlaylistInterActor(repository)

            `when`(repository.getPlaylist())
                .thenThrow(Throwable())

            //act
            interActor.getPlaylist().singleOrNull()
        }

}
package com.podcastapp.features.playlist.presentation.viewmodel

import com.podcastapp.core.exception.PodcastException
import com.podcastapp.core.extension.emitFlow
import com.podcastapp.utils.getMockedPlaylistResponse
import com.podcastapp.features.playlist.data.source.map
import com.podcastapp.features.playlist.domain.PodcastPlaylistInterActor
import com.podcastapp.features.playlist.presentation.map
import com.podcastapp.utils.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class PodcastPlaylistViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


    @Test
    fun `given getPlaylist() is called, when data still loading, then return loading State`() =
        runTest {
            //arrange
            val mockResponse = getMockedPlaylistResponse()
            val playlist = mockResponse.map()
            val expected = PodcastPlaylistState.Loading
            val interActor = mock(PodcastPlaylistInterActor::class.java)
            val viewModel = PodcastPlaylistViewModel(interActor)

            `when`(interActor.getPlaylist())
                .thenReturn(emitFlow {
                    delay(1000)
                    playlist
                })

            val stateList = arrayListOf<PodcastPlaylistState>()
            val job = backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                viewModel.screenState.take(2).collect { stateList.add(it) }
            }

            //act

            viewModel.getPlaylist()

            //assert
            assertEquals(expected, stateList[1])
            job.cancel()
        }

    @Test
    fun `given getPlaylist() is called, when data loaded, then return success State`() =
        runTest {
            //arrange
            val mockResponse = getMockedPlaylistResponse()
            val playlist = mockResponse.map()
            val playlistUI = playlist.map()
            val expected = PodcastPlaylistState.Success(playlistUI)
            val interActor = mock(PodcastPlaylistInterActor::class.java)
            val viewModel = PodcastPlaylistViewModel(interActor)

            `when`(interActor.getPlaylist())
                .thenReturn(emitFlow { playlist })

            val stateList = arrayListOf<PodcastPlaylistState>()
            val job = backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                viewModel.screenState.take(2).collect { stateList.add(it) }
            }

            //act

            viewModel.getPlaylist()

            //assert
            assertEquals(expected, stateList[1])
            job.cancel()
        }

    @Test
    fun `given getPlaylist() is called, when data loading fail, then return error State`() =
        runTest {
            //arrange
            val expected = PodcastPlaylistState.Error(PodcastException.ServerDown)
            val interActor = mock(PodcastPlaylistInterActor::class.java)
            val viewModel = PodcastPlaylistViewModel(interActor)

            `when`(interActor.getPlaylist())
                .thenReturn(emitFlow { throw Throwable() })

            val stateList = arrayListOf<PodcastPlaylistState>()
            val job = backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                viewModel.screenState.take(2).collect { stateList.add(it) }
            }

            //act

            viewModel.getPlaylist()

            //assert
            assertEquals(expected, stateList[1])
            job.cancel()
        }
}
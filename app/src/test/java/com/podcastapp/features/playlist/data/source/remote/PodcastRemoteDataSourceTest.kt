package com.podcastapp.features.playlist.data.source.remote

import com.podcastapp.features.playlist.data.LoginBody
import com.podcastapp.features.playlist.data.PlayListResponse
import com.podcastapp.features.playlist.data.UserToken
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class PodcastRemoteDataSourceTest {
    @Test
    fun `given login() is called, when credentials is correct, then login success`() = runTest {
        //arrange
        val loginBody = LoginBody()
        val expected = mock(UserToken::class.java)
        val api = mock(PodcastApi::class.java)
        val remoteDataSource = PodcastRemoteDataSource(api)

        `when`(api.login(loginBody)).thenReturn(expected)

        //act
        val result = remoteDataSource.login().singleOrNull()

        //assert
        assertEquals(expected, result)
    }

    @Test(expected = Throwable::class)
    fun `given login() is called, when credentials is wrong, then login should fail`() = runTest {
        //arrange
        val loginBody = LoginBody()
        val api = mock(PodcastApi::class.java)
        val remoteDataSource = PodcastRemoteDataSource(api)

        `when`(api.login(loginBody)).thenThrow(Throwable())

        //act
        remoteDataSource.login().singleOrNull()
    }

    @Test
    fun `given getPlaylist() is called, when data loaded, then return playlist response`() =
        runTest {
            //arrange
            val token = "access_token"
            val bearerToken = "Bearer access_token"
            val expected = mock(PlayListResponse::class.java)
            val api = mock(PodcastApi::class.java)
            val remoteDataSource = PodcastRemoteDataSource(api)

            `when`(api.getPlayList(token = bearerToken)).thenReturn(expected)

            //act
            val result = remoteDataSource.getPlaylist(token).singleOrNull()

            //assert
            assertEquals(expected, result)
        }

    @Test(expected = Throwable::class)
    fun `given getPlaylist() is called, when data loading fail, then return return error`() =
        runTest {
            //arrange
            val token = "access_token"
            val bearerToken = "Bearer access_token"
            val expected = mock(PlayListResponse::class.java)
            val api = mock(PodcastApi::class.java)
            val remoteDataSource = PodcastRemoteDataSource(api)

            `when`(api.getPlayList(token = bearerToken)).thenThrow(Throwable())

            //act
            remoteDataSource.getPlaylist(token).singleOrNull()
        }
}
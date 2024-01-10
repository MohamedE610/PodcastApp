package com.podcastapp.features.playlist.data.source.remote

import com.podcastapp.features.playlist.data.LoginBody
import com.podcastapp.features.playlist.data.PlayListResponse
import com.podcastapp.features.playlist.data.UserToken
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface PodcastApi {
    @POST("/api/auth/login")
    fun login(@Body body: LoginBody = LoginBody()): UserToken

    @GET("/api/playlist/{playlist_id}")
    fun getPlayList(
        @Header("Authorization") token: String,
        @Path("playlist_id") playlistId: String = PODCAST_PLAY_LIST_ID
    ): PlayListResponse
}

private const val PODCAST_PLAY_LIST_ID = "01GVD0TTY5RRMHH6YMCW7N1H70"

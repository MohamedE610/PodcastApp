package com.podcastapp.features.playlist.data

import com.google.gson.annotations.SerializedName

private const val EMAIL = "ajbusaleh@gmail.com"
private const val PASSWORD = "123123aJ*"

data class LoginBody(
    @SerializedName("email")
    val email: String = EMAIL,
    @SerializedName("password")
    val password: String = PASSWORD
)

data class UserToken(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("expiresIn")
    val expiresIn: Long
)


data class PlayListResponse(
    @SerializedName("data")
    val data: PlaylistData
)

data class PlaylistData(
    @SerializedName("playlist")
    val playlist: PlayListInfoData,
    @SerializedName("episodes")
    val episodes: List<EpisodeData>
)

data class PlayListInfoData(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("access")
    val access: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("episodeCount")
    val episodeCount: Int,
    @SerializedName("episodeTotalDuration")
    val episodeTotalDuration: Long,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("isDeleted")
    val isDeleted: Boolean,
    @SerializedName("followingCount")
    val followingCount: Int,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("isSubscribed")
    val isSubscribed: Boolean,
)

data class EpisodeData(
    @SerializedName("id")
    val id: String,
    @SerializedName("itunesId")
    val itunesId: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageBigger")
    val imageBigger: String,
    @SerializedName("audioLink")
    val audioLink: String,
    @SerializedName("duration")
    val duration: Long,
    @SerializedName("durationInSeconds")
    val durationInSeconds: Long,
    @SerializedName("views")
    val views: Int,
    @SerializedName("podcastItunesId")
    val podcastItunesId: String,
    @SerializedName("podcastName")
    val podcastName: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("isDeleted")
    val isDeleted: Boolean,
    @SerializedName("isEditorPick")
    val isEditorPick: Boolean,
    @SerializedName("sentNotification")
    val sentNotification: Boolean,
    @SerializedName("position")
    val position: Int
)
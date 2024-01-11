package com.podcastapp.features.playlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.podcastapp.core.exception.PodcastException
import com.podcastapp.core.exception.toPodcastException
import com.podcastapp.features.playlist.domain.PodcastPlaylistInterActor
import com.podcastapp.features.playlist.presentation.EpisodeUI
import com.podcastapp.features.playlist.presentation.MediaState
import com.podcastapp.features.playlist.presentation.PlaylistUI
import com.podcastapp.features.playlist.presentation.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import okhttp3.internal.filterList
import javax.inject.Inject

@HiltViewModel
class PodcastPlaylistViewModel @Inject constructor(
    private val interActor: PodcastPlaylistInterActor
) : ViewModel() {
    private var playlistUI: PlaylistUI? = null
    internal val playlistTile get() = playlistUI?.info?.name
    private var currentPlayingEpisode: EpisodeUI? = null

    private val _screenState: MutableStateFlow<PodcastPlaylistState> by lazy {
        MutableStateFlow(PodcastPlaylistState.Initial)
    }

    internal val screenState: StateFlow<PodcastPlaylistState> = _screenState

    fun getPlaylist() {
        viewModelScope.launch {
            _screenState.value = PodcastPlaylistState.Loading
            interActor.getPlaylist()
                .catch {
                    it.printStackTrace()
                    _screenState.value = PodcastPlaylistState.Error(it.toPodcastException())
                }.collect {
                    playlistUI = it.map()
                    _screenState.value = PodcastPlaylistState.Success(it.map())
                }
        }
    }

    fun handleOnMediaStarted() {
        currentPlayingEpisode =
            currentPlayingEpisode?.copy(state = MediaState.Play, isLoading = false)
        updateData()
    }

    fun handleOnMediaCompleted() {
        currentPlayingEpisode =
            currentPlayingEpisode?.copy(state = MediaState.Idle, isLoading = false)
        updateData()
    }

    fun handleOnPlayLogic(episode: EpisodeUI) {
        currentPlayingEpisode = episode.copy(
            state = MediaState.Play,
            isLoading = episode.state == MediaState.Idle
        )
        resetThePlayingOnes()
        updateData()
    }

    fun handleOnPauseLogic(episode: EpisodeUI) {
        currentPlayingEpisode = episode.copy(state = MediaState.Pause, isLoading = false)
        updateData()
    }

    private fun resetThePlayingOnes() {
        val newList = arrayListOf<EpisodeUI>().apply {
            addAll(playlistUI?.episodes ?: listOf())
            filter { it.id != currentPlayingEpisode?.id }.let { filteredList ->
                filteredList.map { it.copy(state = MediaState.Idle) }
            }
        }

        playlistUI = playlistUI?.copy(episodes = newList)
    }

    private fun updateData() {
        val newList = arrayListOf<EpisodeUI>().apply {
            addAll(playlistUI?.episodes ?: listOf())
        }.apply {
            val index = indexOfFirst { currentPlayingEpisode?.id == it.id }
            removeAt(index)
            add(index, currentPlayingEpisode ?: return)
        }
        _screenState.value =
            PodcastPlaylistState.UpdatedData(playlistUI?.copy(episodes = newList) ?: return)
    }

    fun handleOnMediaError() {
        resetAllMedia()
        _screenState.value =
            PodcastPlaylistState.MediaError(playlistUI ?: return, PodcastException.Business)
    }

    private fun resetAllMedia() {
        val newList = arrayListOf<EpisodeUI>().apply {
            addAll(playlistUI?.episodes ?: listOf())
            map { it.copy(state = MediaState.Idle) }
        }
        playlistUI = playlistUI?.copy(episodes = newList)
    }

}

sealed class PodcastPlaylistState {
    data object Initial : PodcastPlaylistState()
    data object Loading : PodcastPlaylistState()
    data class Success(val data: PlaylistUI) : PodcastPlaylistState()
    data class UpdatedData(val data: PlaylistUI) : PodcastPlaylistState()
    data class MediaError(val data: PlaylistUI, val ex: PodcastException) : PodcastPlaylistState()
    data class Error(val ex: PodcastException) : PodcastPlaylistState()
}
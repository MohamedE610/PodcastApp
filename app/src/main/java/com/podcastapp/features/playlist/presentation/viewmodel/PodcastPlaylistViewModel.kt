package com.podcastapp.features.playlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.podcastapp.core.exception.PodcastException
import com.podcastapp.core.exception.toPodcastException
import com.podcastapp.features.playlist.domain.PodcastPlaylistInterActor
import com.podcastapp.features.playlist.presentation.PlaylistUI
import com.podcastapp.features.playlist.presentation.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PodcastPlaylistViewModel @Inject constructor(
    private val interActor: PodcastPlaylistInterActor
) : ViewModel() {
    var playlistTile = ""
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
                    playlistTile = it.info.name
                    _screenState.value = PodcastPlaylistState.Success(it.map())
                }
        }
    }
}

sealed class PodcastPlaylistState {
    data object Initial : PodcastPlaylistState()
    data object Loading : PodcastPlaylistState()
    data class Success(val data: PlaylistUI) : PodcastPlaylistState()
    data class Error(val ex: PodcastException) : PodcastPlaylistState()
}
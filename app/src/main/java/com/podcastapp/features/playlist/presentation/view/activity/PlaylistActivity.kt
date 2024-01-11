package com.podcastapp.features.playlist.presentation.view.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.podcastapp.R
import com.podcastapp.core.exception.PodcastException
import com.podcastapp.core.exception.getMessageShouldDisplay
import com.podcastapp.core.extension.getDurationInHoursMin
import com.podcastapp.core.extension.gone
import com.podcastapp.core.extension.loadImage
import com.podcastapp.core.extension.observe
import com.podcastapp.core.extension.setAppLanguage
import com.podcastapp.core.extension.show
import com.podcastapp.core.extension.showErrorSnackBar
import com.podcastapp.core.extension.viewBinding
import com.podcastapp.core.utils.AppBarStateChangeListener
import com.podcastapp.databinding.ActivityPlaylistBinding
import com.podcastapp.features.playlist.presentation.EpisodeUI
import com.podcastapp.features.playlist.presentation.PlaylistUI
import com.podcastapp.features.playlist.presentation.view.adapter.EpisodeAdapter
import com.podcastapp.features.playlist.presentation.viewmodel.PodcastPlaylistState
import com.podcastapp.features.playlist.presentation.viewmodel.PodcastPlaylistViewModel
import com.podcastapp.mediaplayer.MediaPlayerDelegate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaylistActivity : AppCompatActivity() {
    private val viewModel by viewModels<PodcastPlaylistViewModel>()
    private val binding by viewBinding(ActivityPlaylistBinding::inflate)
    private val adapter by lazy { EpisodeAdapter(::onPlay, ::onPause) }

    private val mediaPlayerDelegate by lazy {
        MediaPlayerDelegate().also {
            it.onMediaStarted = { viewModel.handleOnMediaStarted() }
            it.onMediaCompleted = { viewModel.handleOnMediaCompleted() }
            it.onError = { viewModel.handleOnMediaError() }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        observe(viewModel.screenState, ::onScreenStateChanged)
        viewModel.getPlaylist()
    }

    override fun attachBaseContext(newBase: Context?) {
        val language = "ar"
        super.attachBaseContext(newBase?.setAppLanguage(language))
    }

    private fun initViews() {
        with(binding) {
            imgBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
            appBar.addOnOffsetChangedListener(object : AppBarStateChangeListener() {
                override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                    if (state == State.COLLAPSED)
                        tvToolbarTitle.text = viewModel.playlistTile
                    else
                        tvToolbarTitle.text = ""
                }
            })

            with(playlistContent) {
                rvEpisodes.layoutManager =
                    LinearLayoutManager(this@PlaylistActivity, LinearLayoutManager.VERTICAL, false)
                rvEpisodes.adapter = adapter
            }
        }
    }

    private fun onPlay(episode: EpisodeUI) {
        viewModel.handleOnPlayLogic(episode)
        mediaPlayerDelegate.play(episode.audioLink)
    }

    private fun onPause(episode: EpisodeUI) {
        viewModel.handleOnPauseLogic(episode)
        mediaPlayerDelegate.pause()
    }

    private fun onScreenStateChanged(state: PodcastPlaylistState) {
        when (state) {
            is PodcastPlaylistState.Loading -> showLoading()
            is PodcastPlaylistState.Success -> handleSuccessState(state.data)
            is PodcastPlaylistState.UpdatedData -> handleUpdatedDataState(state.data)
            is PodcastPlaylistState.Error -> handleErrorState(state.ex)
            is PodcastPlaylistState.MediaError -> handleMediaErrorState(state.data, state.ex)
            is PodcastPlaylistState.Initial -> Unit
        }
    }

    private fun handleMediaErrorState(data: PlaylistUI, ex: PodcastException) {
        adapter.submitItems(data.episodes)
        handleErrorState(ex)
    }

    private fun handleUpdatedDataState(data: PlaylistUI) {
        adapter.submitItems(data.episodes)
    }

    private fun handleErrorState(ex: PodcastException) {
        binding.root.showErrorSnackBar(errorMessage = ex.getMessageShouldDisplay(this))
    }

    private fun handleSuccessState(data: PlaylistUI) {
        hideLoading()
        adapter.submitItems(data.episodes)
        with(binding) {
            playlistContent.root.show()
            imgPlaylist.loadImage(data.info.image, R.drawable.ic_placeholder)
            tvPlaylistTitle.text = data.info.name
            tvPlaylistDesc.text = data.info.desc
            playlistContent.tvEpisodesNoAndTotalDuration.text = getString(
                R.string.lbl_episode_no_and_total_duration,
                data.episodes.size.toString(),
                getDurationInHoursMin(data.info.episodeTotalDuration.times(1000))
            )
        }
    }

    private fun showLoading() {
        with(binding) {
            appBarSkeleton.root.show()
            playlistContentSk.root.show()
        }

    }

    private fun hideLoading() {
        with(binding) {
            appBarSkeleton.root.gone()
            playlistContentSk.root.gone()
        }
    }

    override fun onDestroy() {
        mediaPlayerDelegate.release()
        super.onDestroy()
    }
}
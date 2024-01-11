package com.podcastapp

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.podcastapp.core.exception.PodcastException
import com.podcastapp.core.exception.getMessageShouldDisplay
import com.podcastapp.core.extension.getTimeInHoursMinSec
import com.podcastapp.core.extension.loadImage
import com.podcastapp.core.extension.observe
import com.podcastapp.core.extension.setAppLanguage
import com.podcastapp.core.extension.showErrorSnackBar
import com.podcastapp.core.extension.viewBinding
import com.podcastapp.core.utils.AppBarStateChangeListener
import com.podcastapp.databinding.ActivityMainBinding
import com.podcastapp.features.playlist.presentation.EpisodeUI
import com.podcastapp.features.playlist.presentation.PlaylistUI
import com.podcastapp.features.playlist.presentation.view.EpisodeAdapter
import com.podcastapp.features.playlist.presentation.viewmodel.PodcastPlaylistState
import com.podcastapp.features.playlist.presentation.viewmodel.PodcastPlaylistViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<PodcastPlaylistViewModel>()
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val adapter by lazy { EpisodeAdapter(::onPlayBtnClicked) }

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
            imgPlay.setOnClickListener { handlePlayAllInOrderLogic() }
            btnPlayRandom.setOnClickListener { handlePlayAllRandomlyLogic() }
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
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                rvEpisodes.adapter = adapter
            }
        }
    }

    private fun handlePlayAllRandomlyLogic() {
        //TODO("Not yet implemented")
    }

    private fun handlePlayAllInOrderLogic() {
        //TODO("Not yet implemented")
    }

    private fun onPlayBtnClicked(episode: EpisodeUI) {
        //TODO("Not yet implemented")
    }

    private fun onScreenStateChanged(state: PodcastPlaylistState) {
        when (state) {
            is PodcastPlaylistState.Loading -> showLoading()
            is PodcastPlaylistState.Success -> handleSuccessState(state.data)
            is PodcastPlaylistState.Error -> handleErrorState(state.ex)
            is PodcastPlaylistState.Initial -> Unit
        }
    }

    private fun handleErrorState(ex: PodcastException) {
        binding.root.showErrorSnackBar(errorMessage = ex.getMessageShouldDisplay(this))
    }

    private fun handleSuccessState(data: PlaylistUI) {
        hideLoading()
        adapter.submitItems(data.episodes)
        with(binding) {
            imgPlaylist.loadImage(data.info.image, R.drawable.ic_placeholder)
            tvPlaylistTitle.text = data.info.name
            tvPlaylistDesc.text = data.info.desc
            playlistContent.tvEpisodesNoAndTotalDuration.text = getString(
                R.string.lbl_episode_no_and_total_duration,
                data.episodes.size.toString(),
                getTimeInHoursMinSec(data.info.episodeTotalDuration.times(1000))
            )
        }
    }

    private fun showLoading() {
        //TODO
    }

    private fun hideLoading() {
        //TODO
    }
}
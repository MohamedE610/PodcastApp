package com.podcastapp.features.playlist.presentation.view.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.podcastapp.R
import com.podcastapp.core.extension.formatDate
import com.podcastapp.core.extension.getDurationInHoursMin
import com.podcastapp.core.extension.gone
import com.podcastapp.core.extension.loadImage
import com.podcastapp.core.extension.show
import com.podcastapp.core.extension.viewBinding
import com.podcastapp.databinding.ItemEpisodeBinding
import com.podcastapp.features.playlist.presentation.EpisodeUI
import com.podcastapp.features.playlist.presentation.MediaState

class EpisodeAdapter(
    private val onPlay: (EpisodeUI) -> Unit,
    private val onPause: (EpisodeUI) -> Unit
) : Adapter<EpisodeViewHolder>() {
    private val items = arrayListOf<EpisodeUI>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(parent.viewBinding(ItemEpisodeBinding::inflate), onPlay, onPause)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(episodes: List<EpisodeUI>) {
        items.clear()
        items.addAll(episodes)
        notifyDataSetChanged()
    }
}

class EpisodeViewHolder(
    private val binding: ItemEpisodeBinding,
    private val onPlay: (EpisodeUI) -> Unit,
    private val onPause: (EpisodeUI) -> Unit
) : ViewHolder(binding.root) {
    fun bind(item: EpisodeUI) {
        with(binding) {
            imgEpisode.loadImage(url = item.image, placeholder = R.drawable.ic_placeholder)
            tvEpisodeTitle.text = item.name
            tvPodcastTitle.text = item.podcastName
            val releaseDate = item.releaseDate.formatDate()
            val episodeDuration =
                itemView.context.getDurationInHoursMin(item.durationInSeconds.times(1000))
            tvReleaseDateAndDuration.text = itemView.context.getString(
                R.string.lbl_episode_release_date_and_duration,
                releaseDate,
                episodeDuration
            )

            imgPlay.setOnClickListener {
                when (item.state) {
                    is MediaState.Idle, MediaState.Pause -> onPlay(item)
                    is MediaState.Play -> onPause(item)
                }
            }

            if (item.isLoading) pbLoading.show() else pbLoading.gone()

            bindEpisodeState(item.state)
        }
    }

    private fun ItemEpisodeBinding.bindEpisodeState(state: MediaState) {
        when (state) {
            is MediaState.Idle, is MediaState.Pause -> imgPlay.setImageResource(R.drawable.ic_play)
            is MediaState.Play -> imgPlay.setImageResource(R.drawable.ic_pause)
        }
    }
}
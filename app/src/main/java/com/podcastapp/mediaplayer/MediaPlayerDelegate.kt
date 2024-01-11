package com.podcastapp.mediaplayer

import android.media.AudioAttributes
import android.media.MediaPlayer

class MediaPlayerDelegate {
    var onMediaCompleted: () -> Unit = {}
    var onMediaStarted: () -> Unit = {}
    var onError: () -> Unit = {}

    private var mediaUrl: String? = null

    private var mediaPlayer: MediaPlayer? =
        MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
        }.also {
            it.setOnPreparedListener { player ->
                try {
                    player.start()
                    onMediaStarted()
                } catch (e: Exception) {
                    e.printStackTrace()
                    onError()
                }
            }
        }.also {
            it.setOnCompletionListener {
                onMediaCompleted()
            }
        }.also {
            it.setOnErrorListener { a, b, c ->
                onError()
                true
            }
        }

    fun play(audioUrl: String) {
        mediaPlayer?.apply {
            try {
                if (!mediaUrl.isNullOrEmpty() && mediaUrl == audioUrl) {
                    if (!isPlaying)
                        start()
                    return
                } else if (!mediaUrl.isNullOrEmpty() && mediaUrl != audioUrl) {
                    reset()
                }

                setDataSource(audioUrl)
                prepareAsync()
                mediaUrl = audioUrl
            } catch (e: Exception) {
                onError()
                e.printStackTrace()
            }
        }
    }

    fun pause() {
        try {
            mediaPlayer?.pause()
        } catch (e: Exception) {
            e.printStackTrace()
            onError()
        }
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
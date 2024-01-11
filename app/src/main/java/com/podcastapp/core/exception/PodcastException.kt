package com.podcastapp.core.exception

import android.content.Context
import com.podcastapp.R
import com.podcastapp.core.retrofit.NoConnectivityException
import retrofit2.HttpException

sealed class PodcastException : Throwable() {
    data object NoConnection : PodcastException()
    data object UnAuthorized : PodcastException()
    data object NotFound : PodcastException()
    data object Business : PodcastException()
    data object ServerDown : PodcastException()
}

fun Throwable.toPodcastException(): PodcastException {
    return try {
        when (this) {
            is NoConnectivityException -> PodcastException.NoConnection
            is HttpException -> {
                when (code()) {
                    400 -> PodcastException.Business
                    401 -> PodcastException.UnAuthorized
                    404 -> PodcastException.NotFound
                    else -> PodcastException.ServerDown
                }
            }

            else -> PodcastException.ServerDown
        }
    } catch (e: Exception) {
        PodcastException.ServerDown
    }
}

fun PodcastException.getMessageShouldDisplay(
    ctx: Context,
    generalErrorMsgResId: Int = R.string.lbl_general_error_msg,
    networkErrorMsgResId: Int = R.string.lbl_no_connection_error_msg
): String {
    return when (this) {
        is PodcastException.NoConnection -> ctx.getString(networkErrorMsgResId)
        else -> ctx.getString(generalErrorMsgResId)
    }
}
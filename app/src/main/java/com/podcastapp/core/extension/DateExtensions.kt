package com.podcastapp.core.extension

import android.annotation.SuppressLint
import android.content.Context
import com.podcastapp.R
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


@SuppressLint("SimpleDateFormat")
fun String.formatDate(
    from: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
    to: String = "MMMM yyyy",
    local: Locale = Locale("ar")
): String {
    return try {
        val simpleDateFormat = SimpleDateFormat(from)
        val date = simpleDateFormat.parse(this)
        val formattedDateAsDigitMonth = SimpleDateFormat(to, local)
        formattedDateAsDigitMonth.format(date ?: "")
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

fun Context.getTimeInHoursMinSec(millisSec: Long): String {
    var millis = millisSec
    require(millis >= 0) { "Duration must be greater than zero!" }
    val hours = TimeUnit.MILLISECONDS.toHours(millis)
    millis -= TimeUnit.HOURS.toMillis(hours)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
    millis -= TimeUnit.MINUTES.toMillis(minutes)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
    val sb = StringBuilder()
    sb.append(if (hours < 10) "0${hours}" else hours)
    sb.append(getString(R.string.lbl_reminder_timer_hours))
    sb.append(getString(R.string.lbl_reminder_timer_sparator))
    sb.append(if (minutes < 10) "0${minutes}" else minutes)
    sb.append(getString(R.string.lbl_reminder_timer_minutes))
    return sb.toString()
}
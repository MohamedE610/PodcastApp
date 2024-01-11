package com.podcastapp.core.extension

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*

fun Context.setAppLanguage(language: String): Context? {
    val currentLanguage = getAppLanguage()
    if (language == currentLanguage)
        return this

    val locale = Locale(language)

    return updateResourcesLocale(locale)
}

private fun Context.updateResourcesLocale(locale: Locale): Context? {
    Locale.setDefault(locale)
    val configuration: Configuration = this.resources.configuration
    configuration.setLocale(locale)
    return this.createConfigurationContext(configuration)
}

private fun Context.getAppLanguage(): String {
    val current = resources.configuration.locales.get(0)
    return current.language
}
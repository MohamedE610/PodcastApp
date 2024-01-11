package com.podcastapp.features.playlist.data.di

import android.content.Context
import com.podcastapp.BuildConfig
import com.podcastapp.core.retrofit.ApiServiceFactory
import com.podcastapp.features.playlist.data.source.remote.PodcastApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteSourceModule {
    @Singleton
    @Provides
    fun providePodcastApi(@ApplicationContext context: Context): PodcastApi {
        return ApiServiceFactory.create(
            isDebug = BuildConfig.DEBUG,
            context = context,
            baseUrl = BuildConfig.BASE_URL
        )
    }
}
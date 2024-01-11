package com.podcastapp.core.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

fun <T> FragmentActivity.observe(state: StateFlow<T>, onScreenStateChanged: (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            state.collect { state ->
                onScreenStateChanged(state)
            }
        }
    }
}

fun <T> FragmentActivity.observe(state: SharedFlow<T>, onScreenStateChanged: (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            state.collect { state ->
                onScreenStateChanged(state)
            }
        }
    }
}
package com.podcastapp.core.utils

import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener


/**
 * App bar collapsing state
 * @author Paulo Caldeira <paulo.caldeira></paulo.caldeira>@acin.pt>.
 */
abstract class AppBarStateChangeListener : OnOffsetChangedListener {
    // State
    enum class State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private var mCurrentState = State.IDLE
    override fun onOffsetChanged(appBarLayout: AppBarLayout, i: Int) {
        mCurrentState = if (i == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED)
            }
            State.EXPANDED
        } else if (Math.abs(i) >= appBarLayout.totalScrollRange) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED)
            }
            State.COLLAPSED
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE)
            }
            State.IDLE
        }
    }

    /**
     * Notifies on state change
     * @param appBarLayout Layout
     * @param state Collapse state
     */
    abstract fun onStateChanged(appBarLayout: AppBarLayout?, state: State?)
}
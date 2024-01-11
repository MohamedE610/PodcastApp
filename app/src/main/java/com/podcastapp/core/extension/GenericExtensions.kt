package com.podcastapp.core.extension

import com.google.gson.Gson

fun <T> T.getJson(): String {
    val gson = Gson()
    return gson.toJson(this)
}

inline fun <reified T> String.getObjFromJson(): T {
    val gson = Gson()
    return gson.fromJson(this, T::class.java)
}
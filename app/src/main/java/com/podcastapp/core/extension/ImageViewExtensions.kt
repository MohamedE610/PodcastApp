package com.podcastapp.core.extension

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(imageResId: Int) {
    this.setImageDrawable(ContextCompat.getDrawable(this.context, imageResId))
}

fun ImageView.loadImage(bitmap : Bitmap?, placeholder: Int, error: Int) {
        Glide.with(this.context)
            .load(bitmap)
            .placeholder(placeholder)
            .error(error)
            .into(this)
}

fun ImageView.loadImage(url: String?, placeholder: Int, error: Int ) {
    Glide.with(this.context)
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .into(this)
}

fun ImageView.loadImage(url: String?, placeholder: Int) {
    Glide.with(this.context)
        .load(url)
        .placeholder(placeholder)
        .into(this)
}

fun ImageView.loadImage(url: String?, placeholder: Int, error:Int, cornerValue: Int) {
        Glide.with(this.context)
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(cornerValue)))
            .into(this)
}

fun ImageView.loadImage(bitmap : Bitmap?) {
    if (bitmap != null) {
        Glide.with(this.context).load(bitmap).into(this)
    }
}


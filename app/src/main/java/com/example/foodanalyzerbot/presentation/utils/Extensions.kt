package com.example.foodanalyzerbot.presentation.utils

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.animation.ViewPropertyAnimation
import com.bumptech.glide.request.target.Target

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun ImageView.loadImageFromUrl(
    url: String, errorResource: Int, animator: ViewPropertyAnimation.Animator? = null,
    onExceptionDelegate: () -> Unit = {},
    onResourceReadyDelegate: () -> Unit = {}
) {

    val glideBuilder = Glide.with(this.context)
        .load(Uri.parse(url))
        .crossFade()

    animator?.let {
        glideBuilder.animate(it)
    }

    glideBuilder.diskCacheStrategy(DiskCacheStrategy.RESULT)
        .error(errorResource)
        .listener(object : RequestListener<Uri, GlideDrawable> {
            override fun onException(
                e: java.lang.Exception?, model: Uri?, target: Target<GlideDrawable>?,
                isFirstResource: Boolean
            ): Boolean {
                onExceptionDelegate()
                return false
            }

            override fun onResourceReady(
                resource: GlideDrawable?, model: Uri?, target: Target<GlideDrawable>?,
                isFromMemoryCache: Boolean, isFirstResource: Boolean
            ): Boolean {
                this@loadImageFromUrl.show()
                onResourceReadyDelegate()
                return false
            }
        })
        .into(this)
}
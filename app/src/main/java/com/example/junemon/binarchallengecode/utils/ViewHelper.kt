package com.example.junemon.binarchallengecode.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by ian on 04/March/19.
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun ViewGroup.inflates(layoutResources: Int): View {
    return LayoutInflater.from(context).inflate(layoutResources, this, false)
}
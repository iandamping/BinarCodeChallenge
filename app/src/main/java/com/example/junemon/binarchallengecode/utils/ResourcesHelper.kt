package com.example.junemon.binarchallengecode.utils

import android.content.Context

/**
 * Created by ian on 04/March/19.
 */
fun Context.getStringResources(stringId: Int): String {
    return this.resources.getString(stringId)
}
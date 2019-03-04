package com.example.junemon.binarchallengecode.utils

import android.content.Context

fun Context.getStringResources(stringId:Int):String{
    return this.resources.getString(stringId)
}
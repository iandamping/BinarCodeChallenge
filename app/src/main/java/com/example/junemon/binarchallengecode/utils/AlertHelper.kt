package com.example.junemon.binarchallengecode.utils

import android.content.Context
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

fun Context.alertHelper(tittle: String) {
    this.alert(tittle) {
        yesButton { it.dismiss() }
    }.show()
}

package com.example.junemon.binarchallengecode.utils

import android.content.Context
import android.widget.Toast
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

/**
 * Created by ian on 04/March/19.
 */
fun Context.alertHelper(tittle: String) {
    this.alert(tittle) {
        yesButton { it.dismiss() }
    }.show()
}

fun Context.myToast(tittle: String) {
    Toast.makeText(this, tittle, Toast.LENGTH_SHORT).show()
}

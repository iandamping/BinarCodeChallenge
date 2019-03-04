package com.example.junemon.binarchallengecode.utils

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.junemon.binarchallengecode.MainApplication
import com.example.junemon.binarchallengecode.R
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton

inline fun <reified T : Activity> FragmentActivity.startActivity() {
    startActivity(Intent(this, T::class.java))
    this.overridePendingTransition(R.anim.fade_in_activity, R.anim.fade_out_activity)
    this.finish()
}

inline fun <reified T : Activity> FragmentActivity.startActivityWithValue(key: String, value: String) {
    startActivity(Intent(this, T::class.java).putExtra(key, value))
    this.overridePendingTransition(R.anim.fade_in_activity, R.anim.fade_out_activity)
}

inline fun <reified T : Activity> FragmentActivity.startActivityWithFinish(tittle: String) {
    this.alert(tittle) {
        yesButton {
            MainApplication.prefHelper.deleteSharedPreference()
            startActivity<T>()
            finish()
        }
        noButton {
            it.dismiss()
        }
        onCancelled {
            it.dismiss()
        }
    }.show()
}


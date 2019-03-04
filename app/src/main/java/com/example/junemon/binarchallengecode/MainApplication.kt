package com.example.junemon.binarchallengecode

import android.app.Application
import com.example.junemon.binarchallengecode.utils.PreferenceHelper

class MainApplication : Application() {
    companion object {
        lateinit var prefHelper: PreferenceHelper
    }

    override fun onCreate() {
        super.onCreate()
        prefHelper = PreferenceHelper(this)
    }
}
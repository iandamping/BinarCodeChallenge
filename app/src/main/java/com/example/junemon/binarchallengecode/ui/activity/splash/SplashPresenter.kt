package com.example.junemon.binarchallengecode.ui.activity.splash

import com.example.junemon.binarchallengecode.MainApplication
import com.example.junemon.binarchallengecode.utils.Constant

class SplashPresenter(var mView: SplashView) {
    fun getUserData() {
        val tmpData = MainApplication.prefHelper.getStringInSharedPreference(Constant.saveUserkey)
        if (tmpData.equals("")) {
            mView.isRegistered(false)
        } else {
            mView.isRegistered(true)
        }
    }
}
package com.example.junemon.binarchallengecode.ui.activity.splash

import com.example.junemon.binarchallengecode.MainApplication
import com.example.junemon.binarchallengecode.utils.Constant

/**
 * Created by ian on 04/March/19.
 */
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
package com.example.junemon.binarchallengecode.ui.activity.home

import androidx.fragment.app.FragmentActivity
import com.example.junemon.binarchallengecode.R
import com.example.junemon.binarchallengecode.model.AndroidType
import com.example.junemon.binarchallengecode.ui.activity.splash.SplashActivity
import com.example.junemon.binarchallengecode.utils.getStringResources
import com.example.junemon.binarchallengecode.utils.startActivityWithFinish

class HomePresenter(var mView: HomeView, var act: FragmentActivity) {
    private var allData: MutableList<AndroidType> = mutableListOf()

    fun initData() {
        allData.run {
            add(AndroidType("Cupcake", "Android 1.5", "Api level 3"))
            add(AndroidType("Donut", "Android 1.6", "Api level 4"))
            add(AndroidType("Eclair", "Android 2.0", "Api level 5"))
            add(AndroidType("Froyo", "Android 2.2", "Api level 8"))
            add(AndroidType("Gingerbread", "Android 2.3", "Api level 9"))
            add(AndroidType("Honeycomb", "Android 3.0", "Api level 11"))
            add(AndroidType("Ice Cream Sandwich", "Android 4.0", "Api level 14"))
            add(AndroidType("Jelly Bean", "Android 4.1", "Api level 16"))
            add(AndroidType("KitKat", "Android 4.4", "Api level 19"))
            add(AndroidType("Lollipop", "Android 5.1", "Api level 21"))
            add(AndroidType("Marshmallow", "Android 6.0", "Api level 23"))
            add(AndroidType("Nougat", "Android 7.0", "Api level 24"))
            add(AndroidType("Oreo", "Android 8.0", "Api level 27"))
            add(AndroidType("Pie", "Android 9.0", "Api level 28"))
        }
        mView.getAllListAndroidData(allData)
    }

    fun userLogout() {
        act.startActivityWithFinish<SplashActivity>(act.getStringResources(R.string.logout_user))
    }
}
package com.example.junemon.binarchallengecode.ui.activity.home

import com.example.junemon.binarchallengecode.model.AndroidType

interface HomeView {
    fun getAllListAndroidData(data: List<AndroidType>?)
}
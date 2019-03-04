package com.example.junemon.binarchallengecode.utils

import android.app.Application
import android.content.Context
import com.example.junemon.binarchallengecode.utils.Constant.sharedPrefName

/**
 * Created by ian on 04/March/19.
 */
class PreferenceHelper(app: Application) {
    private val prefHelp by lazy {
        app.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
    }
    private val prefHelperEditor = prefHelp.edit()

    fun saveStringInSharedPreference(key: String?, value: String?) {
        prefHelperEditor.putString(key, value).apply()
    }

    fun getStringInSharedPreference(key: String?): String? {
        return prefHelp.getString(key, "")
    }

    fun deleteSharedPreference() {
        prefHelperEditor.clear().apply()
    }


}
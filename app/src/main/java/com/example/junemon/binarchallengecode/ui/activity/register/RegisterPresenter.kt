package com.example.junemon.binarchallengecode.ui.activity.register

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.junemon.binarchallengecode.MainApplication.Companion.prefHelper
import com.example.junemon.binarchallengecode.R
import com.example.junemon.binarchallengecode.model.User
import com.example.junemon.binarchallengecode.ui.activity.home.HomeActivity
import com.example.junemon.binarchallengecode.utils.Constant.registerIntentKey
import com.example.junemon.binarchallengecode.utils.Constant.registerIntentValues
import com.example.junemon.binarchallengecode.utils.Constant.saveUserkey
import com.example.junemon.binarchallengecode.utils.alertHelper
import com.example.junemon.binarchallengecode.utils.getStringResources
import com.example.junemon.binarchallengecode.utils.startActivity
import com.google.gson.Gson

/**
 * Created by ian on 04/March/19.
 */
class RegisterPresenter(var act: FragmentActivity, var mView: RegisterView) {
    private val gson: Gson = Gson()
    private var user: User = User()

    fun onCreate() {
        val tmpData = prefHelper.getStringInSharedPreference(saveUserkey)
        if (!tmpData.isNullOrEmpty()) {
            user = gson.fromJson(tmpData, User::class.java)
        }
    }

    fun getIntent(intent: Intent) {
        if (intent.extras.getString(registerIntentKey).equals(registerIntentValues, ignoreCase = true)) {
            mView.isLogin(true)
        } else {
            mView.isLogin(false)

        }
    }

    fun register(data: User?) {
        if (data != null) {
            prefHelper.saveStringInSharedPreference(saveUserkey, gson.toJson(data))
            act.startActivity<HomeActivity>()
        }
    }

    fun login(email: String, password: String) {
        if (email.equals(user.email) && password.equals(user.password)) {
            act.startActivity<HomeActivity>()
        } else {
            act.alertHelper(act.getStringResources(R.string.password_wrong))
        }
    }
}
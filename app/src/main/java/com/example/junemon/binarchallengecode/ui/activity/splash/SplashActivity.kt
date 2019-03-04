package com.example.junemon.binarchallengecode.ui.activity.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.junemon.binarchallengecode.R
import com.example.junemon.binarchallengecode.ui.activity.register.RegisterAcitivity
import com.example.junemon.binarchallengecode.utils.Constant.loginIntentKey
import com.example.junemon.binarchallengecode.utils.Constant.loginIntentValues
import com.example.junemon.binarchallengecode.utils.Constant.registerIntentKey
import com.example.junemon.binarchallengecode.utils.Constant.registerIntentValues
import com.example.junemon.binarchallengecode.utils.alertHelper
import com.example.junemon.binarchallengecode.utils.getStringResources
import com.example.junemon.binarchallengecode.utils.myToast
import com.example.junemon.binarchallengecode.utils.startActivityWithValue
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by ian on 04/March/19.
 */

class SplashActivity : AppCompatActivity(), SplashView {
    private lateinit var presenter: SplashPresenter
    private var doubleBackPressed: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.junemon.binarchallengecode.R.layout.activity_splash)
        presenter = SplashPresenter(this)
        presenter.getUserData()
    }

    override fun isRegistered(stat: Boolean) {
        initListener(stat)
    }

    fun initListener(stat: Boolean) {
        btnLogin.setOnClickListener {
            if (!stat) {
                alertHelper(getStringResources(com.example.junemon.binarchallengecode.R.string.please_register))
            } else {
                startActivityWithValue<RegisterAcitivity>(loginIntentKey, loginIntentValues)
            }
        }
        btnRegister.setOnClickListener {
            startActivityWithValue<RegisterAcitivity>(registerIntentKey, registerIntentValues)
        }
    }

    override fun onBackPressed() {
        if (doubleBackPressed) {
            super.onBackPressed()
            return
        }
        this.doubleBackPressed = true
        myToast(getStringResources(R.string.user_out))
        Handler().postDelayed(Runnable { doubleBackPressed = false }, 2000)
    }
}

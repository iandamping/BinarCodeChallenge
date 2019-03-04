package com.example.junemon.binarchallengecode.ui.activity.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.junemon.binarchallengecode.R
import com.example.junemon.binarchallengecode.ui.activity.register.RegisterAcitivity
import com.example.junemon.binarchallengecode.utils.Constant.loginIntentKey
import com.example.junemon.binarchallengecode.utils.Constant.loginIntentValues
import com.example.junemon.binarchallengecode.utils.Constant.registerIntentKey
import com.example.junemon.binarchallengecode.utils.Constant.registerIntentValues
import com.example.junemon.binarchallengecode.utils.alertHelper
import com.example.junemon.binarchallengecode.utils.getStringResources
import com.example.junemon.binarchallengecode.utils.startActivityWithValue
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), SplashView {
    private lateinit var presenter: SplashPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter = SplashPresenter(this)
        presenter.getUserData()
    }

    override fun isRegistered(stat: Boolean) {
        initListener(stat)
    }

    fun initListener(stat: Boolean) {
        btnLogin.setOnClickListener {
            if (!stat) {
                alertHelper(getStringResources(R.string.please_register))
            } else {
                startActivityWithValue<RegisterAcitivity>(loginIntentKey, loginIntentValues)
            }
        }
        btnRegister.setOnClickListener {
            startActivityWithValue<RegisterAcitivity>(registerIntentKey, registerIntentValues)
        }
    }
}

package com.example.junemon.binarchallengecode.ui.activity.register

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.junemon.binarchallengecode.R
import com.example.junemon.binarchallengecode.model.User
import com.example.junemon.binarchallengecode.ui.activity.splash.SplashActivity
import com.example.junemon.binarchallengecode.utils.*
import kotlinx.android.synthetic.main.activity_register.*

/**
 * Created by ian on 04/March/19.
 */
class RegisterAcitivity : AppCompatActivity(), RegisterView {
    private lateinit var user: User
    private lateinit var presenter: RegisterPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter = RegisterPresenter(this, this)
        presenter.getIntent(intent)
        presenter.onCreate()
        user = User()
    }

    fun register() {
        btnRegister.setOnClickListener {
            if (etFullName.text.isNullOrEmpty()) {
                etFullName.requestError(getStringResources(R.string.name_checker))
            } else if (etEmail.text.isNullOrEmpty()) {
                etEmail.requestError(getStringResources(R.string.email_checker))
            } else if (etOrganization.text.isNullOrEmpty()) {
                etOrganization.requestError(getStringResources(R.string.organisasi_checker))
            } else if (etFirstPassword.text.isNullOrEmpty()) {
                etFirstPassword.requestError(getStringResources(R.string.password_checker))
            } else if (etConfirmPassword.text.isNullOrEmpty()) {
                etConfirmPassword.requestError(getStringResources(R.string.password_checker))
            } else {
                user.name = etFullName.text.toString().trim()
                user.email = etEmail.text.toString().trim()
                user.organization = etOrganization.text.toString().trim()
                if (etFirstPassword.text.toString().trim().equals(
                        etConfirmPassword.text.toString().trim(),
                        ignoreCase = true
                    )
                ) {
                    user.password = etFirstPassword.text.toString().trim()
                    presenter.register(user)
                    clearEditText()
                } else {
                    this.alertHelper(getStringResources(R.string.password_not_same))
                }
            }
        }
    }

    fun login() {
        etFullName.gone()
        etOrganization.gone()
        etConfirmPasswordLayout.gone()
        btnRegister.text = resources.getString(R.string.login)
        setTitle(getStringResources(R.string.login))
        btnRegister.setOnClickListener {
            if (etEmail.text.isNullOrEmpty()) {
                etEmail.requestError(getStringResources(R.string.email_checker))
            } else if (etFirstPassword.text.isNullOrEmpty()) {
                etFirstPassword.requestError(getStringResources(R.string.password_checker))
            } else {
                presenter.login(etEmail.text.toString().trim(), etFirstPassword.text.toString().trim())
            }
        }
    }

    override fun isLogin(status: Boolean) {
        if (status) {
            register()
        } else {
            login()
        }
    }


    fun clearEditText() {
        etFullName.clear()
        etEmail.clear()
        etOrganization.clear()
        etFirstPassword.clear()
        etConfirmPassword.clear()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                startActivity<SplashActivity>()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

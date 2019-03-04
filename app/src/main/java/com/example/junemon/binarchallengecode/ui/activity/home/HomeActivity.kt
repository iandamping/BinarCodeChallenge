package com.example.junemon.binarchallengecode.ui.activity.home

import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.junemon.binarchallengecode.R
import com.example.junemon.binarchallengecode.model.AndroidType
import com.example.junemon.binarchallengecode.ui.adapter.HomeAdapter
import com.example.junemon.binarchallengecode.utils.alertHelper
import com.example.junemon.binarchallengecode.utils.getStringResources
import com.example.junemon.binarchallengecode.utils.myToast
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by ian on 04/March/19.
 */
class HomeActivity : AppCompatActivity(), HomeView {
    private lateinit var presenter: HomePresenter
    private var doubleBackPressed: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter = HomePresenter(this, this)
        presenter.initData()
    }

    override fun getAllListAndroidData(data: List<AndroidType>?) {
        rvHome.layoutManager = LinearLayoutManager(this)
        data?.let {
            rvHome.adapter = HomeAdapter(it) {
                alertHelper("You Picked ${it.codeName}")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.menuLogout -> {
                presenter.userLogout()
                true
            }
            else -> super.onOptionsItemSelected(item)
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

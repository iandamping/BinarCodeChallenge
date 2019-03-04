package com.example.junemon.binarchallengecode.ui.activity.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.junemon.binarchallengecode.R
import com.example.junemon.binarchallengecode.model.AndroidType
import com.example.junemon.binarchallengecode.ui.adapter.HomeAdapter
import com.example.junemon.binarchallengecode.utils.alertHelper
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeView {
    lateinit var presenter: HomePresenter
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
}

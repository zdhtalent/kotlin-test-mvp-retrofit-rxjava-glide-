package com.dtct.zdh.kotlintest.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageButton
import android.widget.TextView
import com.dtct.zdh.kotlintest.GlideApp
import com.dtct.zdh.kotlintest.R
import com.dtct.zdh.kotlintest.bean.PrettyGril
import com.dtct.zdh.kotlintest.mvp.GirlContract
import com.dtct.zdh.kotlintest.mvp.presenter.GrilPresenter
import kotlinx.android.synthetic.main.activity_fuel_http.*
import org.jetbrains.anko.toast

class FuelHttpActivity : AppCompatActivity() , GirlContract.View{

    override lateinit var presenter: GirlContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel_http)
        init()
    }

    fun init(){
        val title_bar = findViewById<Toolbar>(R.id.title_bar)
        val back_btn = findViewById<ImageButton>(R.id.back_btn)
        val bar_title = findViewById<TextView>(R.id.bar_title)
        setSupportActionBar(title_bar)
        val actionBar = supportActionBar
        if (actionBar!=null)
            actionBar.setDisplayShowTitleEnabled(false)

        bar_title.text = "MVP+Retrofit2+rxjava2"
        back_btn.setOnClickListener {
            finish()
        }

        presenter = GrilPresenter(this)



//        val http_btn = findViewById<Button>(R.id.http_btn)
//        val http_txt = findViewById<TextView>(R.id.http_txt)

        http_btn.setOnClickListener {
            presenter.getMeiziData()
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun showMeiziData(prettyGril: PrettyGril) {
        http_txt.text = prettyGril.toString()
    }

    override fun showError(errorMsg: String) {
        toast(errorMsg)
    }
}

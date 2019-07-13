package com.dtct.zdh.kotlintest.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.dtct.zdh.kotlintest.R
import com.dtct.zdh.kotlintest.adapter.GlideAdpater
import com.dtct.zdh.kotlintest.bean.PrettyGril
import com.dtct.zdh.kotlintest.mvp.GlideContract
import com.dtct.zdh.kotlintest.mvp.presenter.GlidePresenter
import com.dtct.zdh.kotlintest.mvp.presenter.GrilPresenter
import kotlinx.android.synthetic.main.activity_fuel_http.*
import kotlinx.android.synthetic.main.activity_glide.*
import kotlinx.android.synthetic.main.title_bar_normal.*
import org.jetbrains.anko.toast

class GlideActivity : AppCompatActivity() , GlideContract.View{

    override lateinit var presenter: GlideContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        init()
    }

    fun init(){
        val title_bar = findViewById<Toolbar>(R.id.title_bar)
        setSupportActionBar(title_bar)
        val actionBar = supportActionBar
        if (actionBar!=null)
            actionBar.setDisplayShowTitleEnabled(false)

        bar_title.text = "glide图片加载"
        back_btn.setOnClickListener {
            finish()
        }

        presenter = GlidePresenter(this)

        presenter.getMeiziData()
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
//        http_txt.text = prettyGril.toString()
        glide_listview.adapter = (GlideAdpater(prettyGril.results,this))

    }

    override fun showError(errorMsg: String) {
        toast(errorMsg)
    }
}

package com.dtct.zdh.kotlintest.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import com.dtct.zdh.kotlintest.R
import com.dtct.zdh.kotlintest.adapter.ListViewAdpater

class ListViewActivity : AppCompatActivity() {
    var data= listOf(
        "瓦洛兰",
        "德玛西亚",
        "班德尔城",
        "诺克萨斯",
        "祖安",
        "瓦洛兰",
        "德玛西亚",
        "班德尔城",
        "诺克萨斯",
        "祖安")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
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

        bar_title.text = "ListView"
        back_btn.setOnClickListener {
            finish()
        }

        val listview = findViewById<ListView>(R.id.listview)
        val adpater = ListViewAdpater(data,this)
        listview.adapter = adpater


    }
}

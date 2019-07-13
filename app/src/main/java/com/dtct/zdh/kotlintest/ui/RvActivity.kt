package com.dtct.zdh.kotlintest.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.ImageButton
import android.widget.TextView
import com.dtct.zdh.kotlintest.R
import com.dtct.zdh.kotlintest.adapter.RvAdapter

class RvActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_rv)
        init()
    }

    fun init(){
        var title_bar = findViewById<Toolbar>(R.id.title_bar)
        var back_btn = findViewById<ImageButton>(R.id.back_btn)
        var bar_title = findViewById<TextView>(R.id.bar_title)
        setSupportActionBar(title_bar)
        var actionBar = supportActionBar
        if (actionBar!=null)
            actionBar.setDisplayShowTitleEnabled(false)

        bar_title.text = "RecyclerView"
        back_btn.setOnClickListener {
            finish()
        }

        val layoutManager= LinearLayoutManager(this)
//        val layout=GridLayoutManager(this,2);

        var rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = layoutManager
//        var itemDecoration = RecyclerView.ItemDecoration()
        var adpater = RvAdapter(data,this)
        rv.adapter = adpater
    }
}

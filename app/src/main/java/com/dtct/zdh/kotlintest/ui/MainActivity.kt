package com.dtct.zdh.kotlintest.ui

import android.content.Intent
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.dtct.zdh.kotlintest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val title_bar = findViewById<Toolbar>(R.id.title_bar)
        val back_btn = findViewById<ImageButton>(R.id.back_btn)
        val bar_title = findViewById<TextView>(R.id.bar_title)
        setSupportActionBar(title_bar)
        val actionBar = supportActionBar
        if (actionBar!=null)
            actionBar.setDisplayShowTitleEnabled(false)

        back_btn.visibility = View.GONE
        bar_title.text = "KOTLIN学习"
        val main_btn4 = findViewById<Button>(R.id.main_btn4)
        main_btn4.setOnClickListener {
//            var intent = Intent()
            startActivity(Intent(this, ViewPaperActivity::class.java))
        }

        val main_btn1 = findViewById<Button>(R.id.main_btn1)
        main_btn1.setOnClickListener {
//            var intent = Intent()
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        main_btn2.setOnClickListener {
            //            var intent = Intent()
            startActivity(Intent(this, RvActivity::class.java))
        }

        main_btn3.setOnClickListener {
            //            var intent = Intent()
            startActivity(Intent(this, GridViewActivity::class.java))
        }

        main_btn5.setOnClickListener {
            //            var intent = Intent()
            startActivity(Intent(this, FuelHttpActivity::class.java))
        }

        main_btn6.setOnClickListener {
            //            var intent = Intent()
            startActivity(Intent(this, GlideActivity::class.java))
        }
    }
}

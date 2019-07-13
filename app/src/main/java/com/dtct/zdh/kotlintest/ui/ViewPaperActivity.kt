package com.dtct.zdh.kotlintest.ui

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.dtct.zdh.kotlintest.R
import com.dtct.zdh.kotlintest.adapter.iwh_view_page_adapter

class ViewPaperActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_paper)
        var title_bar = findViewById<Toolbar>(R.id.title_bar)
        var back_btn = findViewById<ImageButton>(R.id.back_btn)
        var bar_title = findViewById<TextView>(R.id.bar_title)
        setSupportActionBar(title_bar)
        var actionBar = supportActionBar
        if (actionBar!=null)
            actionBar.setDisplayShowTitleEnabled(false)

        bar_title.text = "Tablayout+Fragment"
        back_btn.setOnClickListener {
            finish()
        }

        val list_fg = arrayListOf<Fragment>()
        //初始一个fglist存放即将加入的fg
        val fg_left = LeftFragment()//fragment自定的
        val fg_center = CenterFragment()
        val fg_right = RightFragment()

        list_fg.add(fg_left)
        list_fg.add(fg_center)
        list_fg.add(fg_right)

        //list_fg数组，添加进viewpage适配器
        val iwh_tab = findViewById<TabLayout>(R.id.tab)
        //tab组件
        val iwh_viewPage = findViewById<ViewPager>(R.id.viewPage)


        var iwh_view_page_adapter = iwh_view_page_adapter(supportFragmentManager, list_fg)
//viewpage需要一个adapter，参数一：fragmentM管理，参数二：fg集合
        iwh_viewPage.adapter = iwh_view_page_adapter//设置viewpage的adapter
//为viewpage设置adapter
        iwh_tab.setSelectedTabIndicatorColor(Color.parseColor("#185639"))
//tab下划线颜色
        iwh_tab.setTabTextColors(Color.WHITE, Color.WHITE)
//tab标题文字颜色
        iwh_tab.addTab(iwh_tab.newTab().setText("tab1"))
//添加tab面板
        iwh_tab.addTab(iwh_tab.newTab().setText("tab2"))
        iwh_tab.addTab(iwh_tab.newTab().setText("tab3"))
//iwh_tab.setupWithViewPager(iwh_viewPage)//这个使用不可以再使用tababselect监听器
//将viewpage与tablayout绑定一起
        iwh_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                iwh_tab.getTabAt(tab.position)?.select()
                //当tab被选中，改变tab
                iwh_viewPage.setCurrentItem(tab.position, true)
            }

            //当tab被选中，改变viewpage实现同步
            override fun onTabReselected(tab: TabLayout.Tab) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })

        //viewpage事件监听器
        iwh_viewPage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageSelected(position: Int) {
                //党viewpage改变时候，改变对应tab，实现同步
                iwh_tab.getTabAt(position)?.select()
            }
        })


    }
}
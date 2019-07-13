package com.dtct.zdh.kotlintest.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 *Created by zhengdonghui1
 *on 2019-06-21
 */

//继承fragmentPageAdapter，实现两个方法
class iwh_view_page_adapter(fm: FragmentManager, fg_list:ArrayList<Fragment>): FragmentPagerAdapter(fm) {
    private var listFg = arrayListOf<Fragment>()

    init {
        listFg = fg_list
    }

    override fun getCount(): Int {
        return listFg.size
        //返回viewpage页面个数
    }

    override fun getItem(position: Int): Fragment {
        //返回当前页面的fragment页面
        return listFg[position]
    }
}


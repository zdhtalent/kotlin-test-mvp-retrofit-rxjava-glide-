package com.dtct.zdh.kotlintest.mvp.base

/**
 *Created by zhengdonghui1
 *on 2019-07-12
 */
interface BasePresenter {
    /**
     * 开启订阅
     */
    fun subscribe()

    /**
     * 结束订阅
     */
    fun unsubscribe()
}
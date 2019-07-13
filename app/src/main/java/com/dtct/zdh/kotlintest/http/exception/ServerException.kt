package com.dtct.zdh.kotlintest.http.exception

/**
 * 自定义服务器错误
 * Created by hysea on 2018/4/4.
 */
class ServerException(
        /**
         * 错误码
         */
        val code: Int,
        /**
         * 错误信息
         */
        val msg: String) : RuntimeException()

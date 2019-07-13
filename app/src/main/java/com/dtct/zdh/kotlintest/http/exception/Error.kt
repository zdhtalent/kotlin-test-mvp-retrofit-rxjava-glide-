package com.dtct.zdh.kotlintest.http.exception
/**
 *
 */
object Error {
    const val REQUEST_ERROR = "请求出错！"
    const val PARSER_ERROR = "数据解析出错！"
    const val NET_ERROR = "网络异常，请检查您的网络状态！"
    const val NET_TIMEOUT_ERROR = "网络超时，请检查您的网络状态！"
    const val SERVER_ERROR = "服务器异常，请稍后重试！"
}

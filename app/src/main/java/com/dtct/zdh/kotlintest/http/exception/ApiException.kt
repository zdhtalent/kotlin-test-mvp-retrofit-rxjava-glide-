package com.dtct.zdh.kotlintest.http.exception
/**
 * api接口错误/异常统一处理
 * 异常=[程序异常、网络异常、解析异常...]
 * 错误=[接口逻辑错误，-1001:token失效]
 * Created by hysea on 2018/4/4.
 */
class ApiException : Exception {
    /**
     * 错误码
     */
    var code: Int = 0
    /**
     * 错误信息
     */
    var msg: String? = null

    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(code: Int, msg: String) {
        this.code = code
        this.msg = msg
    }
}

package com.dtct.zdh.kotlintest.other

import java.io.Serializable

/**
 * Created by zhouzhengquan on 2017/12/5.
 * 用户类
 */

class UserModel : Serializable {
    val id: Int = 0
    var userName: String = ""
    var sex: Int = 1//性别（1男0女）默认男
}

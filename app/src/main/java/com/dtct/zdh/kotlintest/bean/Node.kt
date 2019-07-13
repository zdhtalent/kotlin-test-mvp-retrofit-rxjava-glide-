package com.dtct.zdh.kotlintest.bean

import java.io.Serializable

/**
 *Created by zhengdonghui1
 *on 2019-07-11
 */
class Node : Serializable{
    var Msgid : String = ""
    var Nodes: List<NodeX> = ArrayList<NodeX>()
    inner class NodeX: Serializable{
        var Alarm: Int = 0
        var Days: Int = 0
        var Name: String = ""
        var Order: String = ""
        var Seq: Int = 0
    }
}


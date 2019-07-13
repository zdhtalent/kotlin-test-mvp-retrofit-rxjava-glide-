package com.dtct.zdh.kotlintest.http.bean

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Reader

/**
 * 基础返回数据结构
 */
data class Resp<T> (
        var code:Int = -10000,
        var data: T? = null,
        var msg: String? = null
){

    class Deserializer<T> : ResponseDeserializable<Resp<T>> {
        override fun deserialize(reader: Reader): Resp<T> {
            val type = object : TypeToken<Resp<T>>() {}.type
            return Gson().fromJson(reader, type)
        }
    }
}

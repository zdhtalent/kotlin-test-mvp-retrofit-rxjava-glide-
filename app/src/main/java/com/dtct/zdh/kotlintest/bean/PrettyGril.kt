package com.dtct.zdh.kotlintest.bean

import java.io.Serializable

/**
 *Created by zhengdonghui1
 *on 2019-07-11
 */
data class PrettyGril(
    val error: Boolean,
    val results: List<Result>
) : Serializable

data class Result(
    val _id: String,
    val createdAt: String,
    val desc: String,
    val publishedAt: String,
    val source: String,
    val type: String,
    val url: String,
    val used: Boolean,
    val who: String
) : Serializable
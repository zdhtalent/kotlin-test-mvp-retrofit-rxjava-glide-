package com.dtct.zdh.kotlintest.http

import com.dtct.zdh.kotlintest.bean.PrettyGril
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *Created by zhengdonghui1
 *on 2019-07-12
 */
interface RetrofitService {
    @GET("/api/data/福利/10/1")
    fun getMeizi(
    ): Observable<PrettyGril>
}
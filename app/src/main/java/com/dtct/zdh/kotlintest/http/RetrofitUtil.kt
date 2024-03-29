package com.dtct.zdh.kotlintest.http

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *Created by zhengdonghui1
 *on 2019-07-12
 */
class RetrofitUtil {
//    val CONNECT_TIME_OUT = 200
//    val READ_TIME_OUT = 200
//    val WRITE_TIME_OUT = 200

    companion object {

        const val TAG="RetrofitUtil"
//        const val BASE_URL = "http://gank.io"

        /**
         * 创建Retrofit
         */
        fun create(url: String): Retrofit {
            //显示日志级别
            val level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
            //新建log拦截器
            val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                Log.e(TAG,"OkHttp:$message")
            })
            loggingInterceptor.level = level
            //okHttpClientBuilder
            val okHttpClientBuilder = OkHttpClient.Builder()

            okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(10, TimeUnit.SECONDS)
            //OkHttp进行添加拦截器loggingInterceptor
            okHttpClientBuilder.addInterceptor(loggingInterceptor)

            return Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        /**
         * 获取ServiceApi
         */
        fun <T> getService(url: String, service: Class<T>): T {
            return create(url).create(service)
        }

        val retrofitService: RetrofitService = RetrofitUtil.getService(Constants.REQUEST_BASE_URL, RetrofitService::class.java)
    }
}

object Constants{
    val REQUEST_BASE_URL="http://gank.io"

    val KEY="1be865c0e67e3"
}
package com.zdy.android.app.loveandroid.repository

import com.zdy.android.app.loveandroid.api.APIs
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 主页数据仓库
 *
 * @date 2022/04/25
 * @author zhangdongyang
 */
object HostRepository {

    private val retrofit: Retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.level =HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .connectTimeout(8, TimeUnit.SECONDS)
            .readTimeout(8, TimeUnit.SECONDS)
            .writeTimeout(8, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl(APIs.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
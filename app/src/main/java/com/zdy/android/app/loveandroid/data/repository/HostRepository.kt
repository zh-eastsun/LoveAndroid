package com.zdy.android.app.loveandroid.data.repository

import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.data.api.WanServices
import com.zdy.android.app.loveandroid.data.bean.HostArticlePageData
import com.zdy.android.app.loveandroid.data.bean.HostBannerData
import com.zdy.android.app.loveandroid.utils.showShortToast
import com.zdy.android.application.architecture.common.base.MyApplication
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
class HostRepository {

    private val retrofit: Retrofit by lazy {
        val logging = HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BODY }

        val client = OkHttpClient.Builder().apply {
            connectTimeout(8, TimeUnit.SECONDS)
            readTimeout(8, TimeUnit.SECONDS)
            writeTimeout(8, TimeUnit.SECONDS)
            addInterceptor(logging)
        }.build()

        Retrofit.Builder()
            .baseUrl(WanServices.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val service by lazy { retrofit.create(WanServices::class.java) }

    // todo 请求失败提示
    suspend fun requestBannerData(): List<HostBannerData>? {
        val response = service.getBanner()
        return if (response.body()?.errorCode == 0) response.body()?.data else {
            showShortToast(
                message = MyApplication.globalContext!!.getString(R.string.network_error_tip)
            )
            null
        }
    }

    // todo 请求失败提示
    suspend fun requestArticleData(): HostArticlePageData? {
        val response = service.getArticle()
        return if (response.body()?.errorCode == 0) response.body()?.data else {
            showShortToast(
                message = MyApplication.globalContext!!.getString(R.string.network_error_tip)
            )
            null
        }
    }
}
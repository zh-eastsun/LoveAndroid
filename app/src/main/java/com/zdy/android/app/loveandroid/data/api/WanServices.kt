package com.zdy.android.app.loveandroid.data.api

import com.zdy.android.app.loveandroid.data.bean.HostBannerResponse
import retrofit2.Response
import retrofit2.http.GET

interface WanServices {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    @GET("banner/json")
    suspend fun getBanner(): Response<HostBannerResponse>
}
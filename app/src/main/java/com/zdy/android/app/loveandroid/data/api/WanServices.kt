package com.zdy.android.app.loveandroid.api

import com.zdy.android.app.loveandroid.data.bean.HostBannerResponse
import retrofit2.Call
import retrofit2.http.GET

interface WanServices {

    companion object{
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    @GET("banner/json")
    suspend fun getBanner(): Call<HostBannerResponse>
}
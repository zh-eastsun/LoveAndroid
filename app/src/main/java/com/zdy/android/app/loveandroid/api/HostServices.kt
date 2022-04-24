package com.zdy.android.app.loveandroid.api

import com.zdy.android.app.loveandroid.bean.ApiResult
import com.zdy.android.app.loveandroid.bean.HostBannerBean
import retrofit2.http.GET

interface HostServices {
    @GET("banner/json")
    suspend fun getBanner(): ApiResult<HostBannerBean>
}
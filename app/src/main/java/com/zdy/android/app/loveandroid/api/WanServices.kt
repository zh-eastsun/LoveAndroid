package com.zdy.android.app.loveandroid.api

import com.zdy.android.app.loveandroid.bean.HostBannerBean
import com.zdy.android.application.architecture.common.data.response.DataResult
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface HostServices {
    @GET("banner/json")
    suspend fun getBanner(): Flow<DataResult<List<HostBannerBean>>>
}
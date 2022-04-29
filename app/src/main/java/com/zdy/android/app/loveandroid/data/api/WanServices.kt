package com.zdy.android.app.loveandroid.data.api

import com.zdy.android.app.loveandroid.data.bean.HostArticlePageData
import com.zdy.android.app.loveandroid.data.bean.HostBannerData
import com.zdy.android.app.loveandroid.data.bean.WanResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WanServices {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    // 主页轮播图
    @GET("banner/json")
    suspend fun getBanner(): Response<WanResponse<List<HostBannerData>>>

    // 主页文章
    @GET("article/list/{page}/json")
    suspend fun getArticle(@Path("page") page: Int = 0): Response<WanResponse<HostArticlePageData>>
}
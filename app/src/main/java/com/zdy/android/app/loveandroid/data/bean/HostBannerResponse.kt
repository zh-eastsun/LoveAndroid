package com.zdy.android.app.loveandroid.data.bean

import com.google.gson.annotations.SerializedName

/**
 * 轮播图网络请求数据模型
 *
 * @date 2022/04/27
 * @author zhangdongyang
 */
data class HostBannerResponse(
    @field:SerializedName("data")       val data: List<HostBannerData>,
    @field:SerializedName("errorCode")  val errorCode: Int,
    @field:SerializedName("errorMsg")   val errorMsg: String
)

package com.zdy.android.app.loveandroid.bean

import com.google.gson.annotations.SerializedName

/**
 * 轮播图数据
 *
 * @date 2022/04/27
 * @author zhangdongyang
 */
data class HostBannerData(
    @field:SerializedName("desc")       val description: String,
    @field:SerializedName("id")         val id: Int,
    @field:SerializedName("imagePath")  val imagePath: String,
    @field:SerializedName("isVisible")  val isVisible: Int,
    @field:SerializedName("order")      val order: Int,
    @field:SerializedName("title")      val title: String,
    @field:SerializedName("type")       val type: Int,
    @field:SerializedName("url")        val url: String
)
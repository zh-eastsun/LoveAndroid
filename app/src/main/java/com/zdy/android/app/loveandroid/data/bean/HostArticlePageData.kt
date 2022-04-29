package com.zdy.android.app.loveandroid.data.bean

/**
 * 主页文章页信息
 *
 * @date 2022/04/29
 * @author zhangdongyang
 */
data class HostArticlePageData(
    val curPage: Int,
    val datas: List<HostArticleDetailedData>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)
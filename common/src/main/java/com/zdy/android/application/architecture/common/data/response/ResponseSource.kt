package com.zdy.android.application.architecture.common.data.response

/**
 * 网络请求源
 *
 * @date 2022/04/25
 * @author zhangdongyang
 */
enum class ResponseSource {
    NETWORK,    // 网络数据
    DATABASE,   // 数据库数据
    LOCAL_FILE  // 本地文件数据
}
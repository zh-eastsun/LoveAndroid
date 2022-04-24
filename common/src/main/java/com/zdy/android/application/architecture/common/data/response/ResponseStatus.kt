package com.zdy.android.application.architecture.common.data.response

/**
 * 网络请求返回状态
 *
 * @date 2022/04/25
 * @author zhangdongyang
 */
class ResponseStatus(
    private val responseCode: String,
    private val success: Boolean,
    private val source: ResponseSource = ResponseSource.NETWORK
) {
    fun getResponseCode(): String = this.responseCode

    fun getSuccess(): Boolean = this.success

    fun getSource(): ResponseSource = this.source
}
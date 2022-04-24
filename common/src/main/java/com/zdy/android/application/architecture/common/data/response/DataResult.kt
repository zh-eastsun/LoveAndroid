package com.zdy.android.application.architecture.common.data.response

/**
 * 网络请求结果
 *
 * @date 2022/04/25
 * @author zhangdongyang
 */
class DataResult<T>(
    private val mEntity: T,
    private val mStatus: ResponseStatus
) {

    fun getResult() = this.mEntity

    fun getResponseStatus() = this.mStatus

    interface Result<T> {
        fun onResult(dataResult: DataResult<T>)
    }
}
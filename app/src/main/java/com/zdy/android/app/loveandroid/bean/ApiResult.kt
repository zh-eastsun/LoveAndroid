package com.zdy.android.app.loveandroid.bean

data class ApiResult<T>(
    val code: Int,
    val result: T)
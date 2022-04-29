package com.zdy.android.app.loveandroid.utils

import android.content.Context
import android.widget.Toast
import com.zdy.android.application.architecture.common.base.MyApplication

fun showShortToast(context: Context = MyApplication.globalContext!!, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun showLongToast(context: Context = MyApplication.globalContext!!, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}
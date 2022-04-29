package com.zdy.android.application.architecture.common.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

class MyApplication : Application(), ViewModelStoreOwner {

    private val applicationStore: ViewModelStore by lazy { ViewModelStore() }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        var globalContext: Context? = null
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        globalContext = base
    }

    override fun getViewModelStore(): ViewModelStore {
        return applicationStore
    }
}
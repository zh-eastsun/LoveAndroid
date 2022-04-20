package com.zdy.android.application.architecture.common.base

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

class MyApplication : Application(), ViewModelStoreOwner {

    private val applicationStore: ViewModelStore by lazy { ViewModelStore() }

    override fun getViewModelStore(): ViewModelStore {
        return applicationStore
    }
}
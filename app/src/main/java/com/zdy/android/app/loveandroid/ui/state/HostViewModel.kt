package com.zdy.android.app.loveandroid.ui.state

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zdy.android.app.loveandroid.data.bean.HostBannerData
import com.zdy.android.app.loveandroid.data.repository.HostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HostViewModel : ViewModel() {

    val repository = HostRepository()
    val hostBannerData: MutableLiveData<List<HostBannerData>> = MutableLiveData()

    fun loadBannerData() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.requestBannerData()
            hostBannerData.postValue(res)
        }
    }
}
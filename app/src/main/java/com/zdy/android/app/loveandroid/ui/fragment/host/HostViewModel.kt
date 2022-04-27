package com.zdy.android.app.loveandroid.ui.fragment.host

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zdy.android.app.loveandroid.data.bean.HostBannerData
import com.zdy.android.app.loveandroid.data.repository.HostRepository

class HostViewModel : ViewModel() {
    val repository = HostRepository()
    val hostBannerData: MutableLiveData<List<HostBannerData>> = MutableLiveData()
}
package com.zdy.android.app.loveandroid.ui.state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zdy.android.app.loveandroid.data.bean.HostBannerData
import com.zdy.android.app.loveandroid.data.repository.HostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 主页数据模型
 *
 * @date 2022/04/29
 * @author zhangdongyang
 */
class HostViewModel : ViewModel() {
    // todo 改造数据仓库，使其成为唯一可信源
    // 数据仓库
    private val repository = HostRepository()
    // 数据模型
    val hostBannerData by lazy {
        object : MutableLiveData<List<HostBannerData>>() {
            init {
                value = ArrayList()
            }
        }
    }

    // 加载轮播图数据
    fun loadBannerData() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.requestBannerData()
            hostBannerData.postValue(res)
        }
    }
}
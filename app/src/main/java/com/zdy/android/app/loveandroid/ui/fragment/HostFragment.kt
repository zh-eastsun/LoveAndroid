package com.zdy.android.app.loveandroid.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.adapter.HostBannerAdapter
import com.zdy.android.app.loveandroid.ui.state.HostViewModel
import com.zdy.android.application.architecture.common.base.BaseFragment
import com.zdy.android.application.architecture.common.base.binding.DataBindingConfig

/**
 * 首页页面
 *
 * @date 2022/04/19
 * @author zhangdongyang
 */
class HostFragment : BaseFragment() {

    private val TAG = this::class.java.simpleName

    // 保存状态的ViewModel
    private val mState: HostViewModel by viewModels()

    override fun getDataBindingConfig(): DataBindingConfig {
        val mAdapter = HostBannerAdapter(requireContext())
        return DataBindingConfig(R.layout.fragment_host, BR.stateViewModel, mState)
            .addBindingParam(BR.bannerAdapter, mAdapter)
            .addBindingParam(BR.stateViewModel, mState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(mState.hostBannerData.value?.size == 0) {
            mState.loadBannerData()
        }
    }

}
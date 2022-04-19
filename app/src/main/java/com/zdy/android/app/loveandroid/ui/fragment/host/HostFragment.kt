package com.zdy.android.app.loveandroid.ui.fragment.host

import androidx.fragment.app.viewModels
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.base.BaseFragment
import com.zdy.android.app.loveandroid.base.binding.DataBindingConfig

/**
 * 首页页面
 *
 * @date 2022/04/19
 * @author zhangdongyang
 */
class HostFragment : BaseFragment() {

    // 业务自己的ViewModel
    private val hostViewModel: HostViewModel by viewModels()

    override fun getDataBindingConfig(): DataBindingConfig =
        DataBindingConfig(
            R.layout.fragment_host,
            BR.hostFragmentViewModel,
            hostViewModel
        )
}
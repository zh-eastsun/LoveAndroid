package com.zdy.android.app.loveandroid.ui.fragment.system

import androidx.fragment.app.viewModels
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.application.architecture.common.base.BaseFragment
import com.zdy.android.application.architecture.common.base.binding.DataBindingConfig

/**
 * 体系页面
 *
 * @date 2022/04/20
 * @author zhangdongyang
 */
class SystemFragment : BaseFragment(){

    private val systemViewModel: SystemViewModel by viewModels()

    override fun getDataBindingConfig(): DataBindingConfig = DataBindingConfig(
        R.layout.fragment_system,
        BR.systemViewModel,
        systemViewModel
    )
}
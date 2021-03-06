package com.zdy.android.app.loveandroid.ui.fragment

import androidx.fragment.app.viewModels
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.ui.state.OfficialViewModel
import com.zdy.android.application.architecture.common.base.BaseFragment
import com.zdy.android.application.architecture.common.base.binding.DataBindingConfig

/**
 * 公众号页面
 *
 * @date 2022/04/20
 * @author zhangdongyang
 */
class OfficialFragment : BaseFragment() {

    // 业务自己的ViewModel
    private val officialViewModel: OfficialViewModel by viewModels()

    override fun getDataBindingConfig(): DataBindingConfig = DataBindingConfig(
        R.layout.fragment_official,
        BR.officialViewModel,
        officialViewModel
    )
}
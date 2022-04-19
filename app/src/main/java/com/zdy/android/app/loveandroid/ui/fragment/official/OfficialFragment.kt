package com.zdy.android.app.loveandroid.ui.fragment.official

import androidx.fragment.app.viewModels
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.base.BaseFragment
import com.zdy.android.app.loveandroid.base.binding.DataBindingConfig

class OfficialFragment : BaseFragment() {

    // 业务自己的ViewModel
    private val officialViewModel: OfficialViewModel by viewModels()

    override fun getDataBindingConfig(): DataBindingConfig = DataBindingConfig(
        R.layout.fragment_official,
        BR.officialFragmentViewModel,
        officialViewModel
    )
}
package com.zdy.android.app.loveandroid.ui.fragment.host

import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.base.BaseFragment
import com.zdy.android.app.loveandroid.base.binding.DataBindingConfig

class HostFragment : BaseFragment() {

    private var fragmentViewModel: HostViewModel? = null

    override fun initViewModel() {
        fragmentViewModel = getFragmentScopeViewModel(HostViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig =
        DataBindingConfig(
            R.layout.fragment_host,
            BR.hostFragmentViewModel,
            fragmentViewModel!!
        )
}
package com.zdy.android.app.loveandroid.ui.fragment.project

import androidx.fragment.app.viewModels
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.base.BaseFragment
import com.zdy.android.app.loveandroid.base.binding.DataBindingConfig

/**
 * 项目界面
 *
 * @date 2022/04/20
 * @author zhangdongyang
 */
class ProjectFragment : BaseFragment(){

    private val projectViewModel: ProjectViewModel by viewModels()

    override fun getDataBindingConfig(): DataBindingConfig = DataBindingConfig(
        R.layout.fragment_project,
        BR.projectViewModel,
        projectViewModel
    )
}
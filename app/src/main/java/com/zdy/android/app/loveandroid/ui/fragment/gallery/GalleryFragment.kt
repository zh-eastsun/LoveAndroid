package com.zdy.android.app.loveandroid.ui.fragment.gallery

import androidx.fragment.app.viewModels
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.application.architecture.common.base.BaseFragment
import com.zdy.android.application.architecture.common.base.binding.DataBindingConfig

/**
 * 导航页面
 *
 * @date 2022/04/19
 * @author zhangdongyang
 */
class GalleryFragment : BaseFragment() {

    // 业务自己的ViewModel
    private val galleryViewModel: GalleryViewModel by viewModels()

    override fun getDataBindingConfig(): DataBindingConfig =
        DataBindingConfig(
            R.layout.fragment_gallery,
            BR.galleryViewModel,
            galleryViewModel
        )
}
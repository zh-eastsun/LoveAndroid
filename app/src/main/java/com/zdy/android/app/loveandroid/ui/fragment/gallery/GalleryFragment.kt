package com.zdy.android.app.loveandroid.ui.fragment.gallery

import androidx.fragment.app.viewModels
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.base.BaseFragment
import com.zdy.android.app.loveandroid.base.binding.DataBindingConfig

class GalleryFragment : BaseFragment() {

    // 业务自己的ViewModel
    private val galleryViewModel: GalleryViewModel by viewModels()

    override fun getDataBindingConfig(): DataBindingConfig =
        DataBindingConfig(
            R.layout.fragment_gallery,
            BR.galleryFragmentViewModel,
            galleryViewModel
        )
}
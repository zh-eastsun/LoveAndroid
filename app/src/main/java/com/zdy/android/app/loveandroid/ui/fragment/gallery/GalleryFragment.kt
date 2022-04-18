package com.zdy.android.app.loveandroid.ui.fragment.gallery

import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.base.BaseFragment
import com.zdy.android.app.loveandroid.base.binding.DataBindingConfig

class GalleryFragment : BaseFragment() {

    private var fragmentViewModel: GalleryViewModel? = null

    override fun initViewModel() {
        fragmentViewModel = getFragmentScopeViewModel(GalleryViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig =
        DataBindingConfig(
            R.layout.fragment_gallery,
            BR.galleryFragmentViewModel,
            fragmentViewModel!!
        )
}
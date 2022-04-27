package com.zdy.android.app.loveandroid.ui.fragment.host

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.adapter.HostBannerAdapter
import com.zdy.android.application.architecture.common.base.BaseFragment
import com.zdy.android.application.architecture.common.base.adapter.BaseDataBindingAdapter.OnItemClickListener
import com.zdy.android.application.architecture.common.base.binding.DataBindingConfig

/**
 * 首页页面
 *
 * @date 2022/04/19
 * @author zhangdongyang
 */
class HostFragment : BaseFragment() {

    // 保存状态的ViewModel
    private val mState: HostViewModel by viewModels()

    override fun getDataBindingConfig(): DataBindingConfig {

        val adapter = HostBannerAdapter(requireContext())
        adapter.onItemClickListener = object : OnItemClickListener<String> {
            override fun onItemClick(viewId: Int, itemData: String, position: Int) {
                Toast.makeText(requireContext(), "点击了第${position}个元素", Toast.LENGTH_SHORT).show()
            }
        }
        val data = MutableList(40) {
            "数据$it"
        }
        adapter.submitList(data)

        return DataBindingConfig(
            R.layout.fragment_host,
            BR.stateViewModel,
            mState
        ).addBindingParam(BR.bannerAdapter, adapter)
            .addBindingParam(BR.stateViewModel, mState)
    }

}
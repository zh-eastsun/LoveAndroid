package com.zdy.android.app.loveandroid.ui.fragment.host

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private val TAG = this::class.java.simpleName

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("hello","data:")
        val root = super.onCreateView(inflater, container, savedInstanceState)
        mState.hostBannerData.observe(viewLifecycleOwner){
            Log.e("hello","data:$it")
        }
        mState.loadBannerData()
        return root
    }

}
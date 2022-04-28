package com.zdy.android.app.loveandroid.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zdy.android.app.loveandroid.data.bean.HostBannerData

/**
 * 主页轮播图视图绑定适配器
 *
 * @date 2022/04/28
 * @author zhangdongyang
 */
class HostBannerBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["submitList"], requireAll = false)
        fun setList(recycler: RecyclerView, list: List<HostBannerData>) {
            val adapter = recycler.adapter as HostBannerAdapter
            adapter.submitList(list)
        }
    }
}
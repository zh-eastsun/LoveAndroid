package com.zdy.android.application.architecture.common.base.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.Adapter

/**
 * RecyclerView的数据-视图绑定集合
 *
 * @date 2022/04/24
 * @author zhangdongyang
 */
class RecyclerViewBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter(
            value = ["adapter"],
            requireAll = false
        )
        fun <T : ViewHolder> setAdapter(
            recyclerView: RecyclerView,
            adapter: Adapter<T>
        ) {
            recyclerView.adapter = adapter
        }
    }
}
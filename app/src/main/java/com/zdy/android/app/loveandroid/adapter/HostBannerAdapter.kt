package com.zdy.android.app.loveandroid.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.databinding.HostBannerItemBinding
import com.zdy.android.application.architecture.common.base.adapter.SimpleDataBindingAdapter

class HostBannerAdapter(context: Context) : SimpleDataBindingAdapter<String, HostBannerItemBinding>(
    context,
    R.layout.host_banner_item,
    DiffUtils.mTestStringItemCallback
) {
    override fun getLayoutResId(viewType: Int): Int {
        TODO("Not yet implemented")
    }

    override fun onBindItem(
        itemDataBinding: HostBannerItemBinding,
        itemData: String,
        itemViewHolder: RecyclerView.ViewHolder
    ) {
        TODO("Not yet implemented")
    }
}
package com.zdy.android.app.loveandroid.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.data.bean.HostBannerData
import com.zdy.android.app.loveandroid.databinding.HostBannerItemBinding
import com.zdy.android.app.loveandroid.utils.DiffUtils
import com.zdy.android.application.architecture.common.base.adapter.SimpleDataBindingAdapter

class HostBannerAdapter(context: Context) : SimpleDataBindingAdapter<HostBannerData, HostBannerItemBinding>(
    context,
    DiffUtils.mHostBannerItemCallback
) {
    override fun getLayoutResId(viewType: Int): Int {
        return R.layout.host_banner_item
    }

    override fun onBindItem(
        itemDataBinding: HostBannerItemBinding,
        itemData: HostBannerData,
        itemViewHolder: RecyclerView.ViewHolder
    ) {
        itemDataBinding.data = itemData
    }
}
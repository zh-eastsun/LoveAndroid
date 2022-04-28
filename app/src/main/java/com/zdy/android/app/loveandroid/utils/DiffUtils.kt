package com.zdy.android.app.loveandroid.utils

import androidx.recyclerview.widget.DiffUtil
import com.zdy.android.app.loveandroid.data.bean.HostBannerData

object DiffUtils {

    val mTestStringItemCallback: DiffUtil.ItemCallback<String> by lazy {
        object : DiffUtil.ItemCallback<String>(){
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }

    val mHostBannerItemCallback: DiffUtil.ItemCallback<HostBannerData> by lazy {
        object : DiffUtil.ItemCallback<HostBannerData>(){
            override fun areItemsTheSame(
                oldItem: HostBannerData,
                newItem: HostBannerData
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: HostBannerData,
                newItem: HostBannerData
            ) = oldItem.description == newItem.description
        }
    }
}
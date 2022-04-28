package com.zdy.android.app.loveandroid.adapter

import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.zdy.android.app.loveandroid.data.bean.HostBannerData

/**
 * 主页轮播图视图绑定适配器
 *
 * @date 2022/04/28
 * @author zhangdongyang
 */
class HostBindingAdapter {

    companion object {

        private const val TAG = "HostBindingAdapter"

        @JvmStatic
        @BindingAdapter(value = ["submitList"], requireAll = false)
        fun submitList(viewPager: ViewPager2, data: List<HostBannerData>) {
            val adapter = viewPager.adapter as HostBannerAdapter
            adapter.submitList(data)
            Log.e(TAG, "submitList: $data", )
        }

        @JvmStatic
        @BindingAdapter(value = ["imagePath"], requireAll = false)
        fun setImagePath(imageView: ImageView, imagePath: String) {
            Log.e(TAG, "setUrl:$imagePath ", )
            Glide.with(imageView.context)
                .load(imagePath)
                .error(ColorDrawable(0xbbbbbb))
                .into(imageView)
        }
    }
}
package com.zdy.android.app.loveandroid.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.zdy.android.application.architecture.common.R

/**
 * 轮播图适配器
 *
 * @date 2022/04/20
 * @author zhangdongyang
 */
class BannerAdapter<T>(
    private var data: List<T>,
    private var loadImage: (context: Context, item: T, imageView: ImageView) -> Unit = { context, _, imageView ->
        Glide.with(context)
            .load(R.drawable.blank_background)
            .into(imageView)
    }
) : PagerAdapter() {

    override fun getCount(): Int = data.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) =
        container.removeView(`object` as View)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(container.context)
        // 等比缩放照片，占满容器
        imageView.scaleType = ImageView.ScaleType.FIT_XY
        loadImage(container.context, data[position], imageView)
        container.addView(imageView)
        return imageView
    }
}
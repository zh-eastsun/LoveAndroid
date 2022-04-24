package com.zdy.android.application.architecture.common.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView底层公共适配器
 *
 * @date 2022/04/24
 * @author zhangdongyang
 */
abstract class BaseDataBindingAdapter<M, B : ViewDataBinding>(
    protected val mContext: Context,
    diffCallback: DiffUtil.ItemCallback<M>
) : ListAdapter<M, RecyclerView.ViewHolder>(diffCallback) {

    protected val onItemClickListener: OnItemClickListener<M>? = null
    protected val onItemLongClickListener: OnItemLongClickListener<M>? = null

    @LayoutRes
    abstract fun getLayoutResId(viewType: Int): Int
    abstract fun onBindItem(
        itemDataBinding: B,
        itemData: M,
        itemViewHolder: RecyclerView.ViewHolder
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(mContext),
            getLayoutResId(viewType),
            parent,
            false
        )
        val holder = BaseBindingViewHolder(viewDataBinding.root)
        holder.itemView.setOnClickListener {
            if (this.onItemClickListener != null) {
                val position = holder.adapterPosition
                onItemClickListener.onItemClick(
                    holder.itemView.id,
                    getItem(position) as M,
                    position
                )
            }
        }
        holder.itemView.setOnLongClickListener {
            if (this.onItemLongClickListener != null) {
                val position = holder.adapterPosition
                onItemLongClickListener.onItemLongClick(
                    holder.itemView.id,
                    getItem(position) as M,
                    position
                )
                return@setOnLongClickListener true
            }
            return@setOnLongClickListener false
        }

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewDataBinding = DataBindingUtil.getBinding<B>(holder.itemView)
        viewDataBinding?.let {
            onBindItem(it, getItem(position) as M, holder)
            viewDataBinding.executePendingBindings()
        }
    }

    /**
     * 单个条目的点击事件
     */
    interface OnItemClickListener<M> {
        fun onItemClick(viewId: Int, itemData: M, position: Int)
    }

    /**
     * 单个条目的长按点击事件
     */
    interface OnItemLongClickListener<M> {
        fun onItemLongClick(viewId: Int, itemData: M, position: Int)
    }

    class BaseBindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
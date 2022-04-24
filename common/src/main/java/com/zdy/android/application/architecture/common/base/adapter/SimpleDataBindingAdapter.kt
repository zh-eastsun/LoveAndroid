package com.zdy.android.application.architecture.common.base.adapter

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil

abstract class SimpleDataBindingAdapter<M, B : ViewDataBinding>(
    context: Context,
    diffCallback: DiffUtil.ItemCallback<M>
) : BaseDataBindingAdapter<M, B>(context, diffCallback)
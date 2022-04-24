package com.zdy.android.app.loveandroid.adapter

import androidx.recyclerview.widget.DiffUtil

object DiffUtils {

    val mTestStringItemCallback: DiffUtil.ItemCallback<String> by lazy {
        object : DiffUtil.ItemCallback<String>(){
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }
}
package com.zdy.android.app.loveandroid.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.base.binding.DataBindingConfig

abstract class BaseFragment : Fragment() {
    private var tvStrictModeTip: TextView? = null
    private var fragmentProvider: ViewModelProvider? = null
    private var activityProvider: ViewModelProvider? = null
    private var applicationProvider: ViewModelProvider? = null
    private var binding: ViewDataBinding? = null

    protected abstract fun initViewModel()
    protected abstract fun getDataBindingConfig(): DataBindingConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("BaseFragment", "onCreateView: ")
        // 将所有DataBinding相关操作都提取到基类中
        val bindingConfig = getDataBindingConfig()
        val dataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                inflater,
                bindingConfig.layout,
                container,
                false
            )
        dataBinding.lifecycleOwner = this
        dataBinding.setVariable(bindingConfig.vmVariableId, bindingConfig.stateViewModel)
        val bindingParams = bindingConfig.bindingParams

        // 遍历dataBinding中的数据
        bindingParams.forEach { key, _ ->
            dataBinding.setVariable(bindingParams.keyAt(key), bindingParams.valueAt(key))
        }
        this.binding = dataBinding
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.unbind()
        binding = null
    }

    protected fun <T : ViewModel> getFragmentScopeViewModel(modelClass: Class<T>): T {
        if (fragmentProvider == null) fragmentProvider = ViewModelProvider(this)
        return fragmentProvider!![modelClass]
    }

    protected fun <T : ViewModel> getActivityScopeViewModel(modelClass: Class<T>): T {
        if (activityProvider == null) activityProvider = ViewModelProvider(this)
        return activityProvider!![modelClass]
    }

    protected fun <T : ViewModel> getApplicationScopeViewModel(modelClass: Class<T>): T {
        if (applicationProvider == null)
            applicationProvider =
                ViewModelProvider(requireActivity().applicationContext as MyApplication)
        return applicationProvider!![modelClass]
    }

    protected fun getBinding(): ViewDataBinding? {
        if (isDebug() && binding != null && tvStrictModeTip == null) {
            tvStrictModeTip = TextView(requireActivity().applicationContext)
            tvStrictModeTip?.let {
                it.alpha = 0.4f
                it.setPadding(
                    it.paddingLeft + 24,
                    it.paddingTop + 64,
                    it.paddingRight + 24,
                    it.paddingBottom + 24
                )
                it.gravity = 1
                it.textSize = 10.0f
                it.setBackgroundColor(-1)
                val tip =
                    getString(
                        R.string.debug_databinding_warning,
                        arrayOf(this.javaClass.simpleName)
                    )
                it.text = tip
                (it.rootView as ViewGroup).addView(tvStrictModeTip)
            }
        }
        return binding
    }

    private fun isDebug() =
        requireActivity().application!!.applicationInfo != null && (requireActivity().application.applicationInfo.flags and 2) != 0
}
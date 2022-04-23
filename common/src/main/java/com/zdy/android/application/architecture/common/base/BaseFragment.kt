package com.zdy.android.application.architecture.common.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zdy.android.application.architecture.common.R
import com.zdy.android.application.architecture.common.base.binding.DataBindingConfig

abstract class BaseFragment : Fragment() {

    private var tvStrictModeTip: TextView? = null
    private var activityProvider: ViewModelProvider? = null     // 通信相关的ViewModel
    private var applicationProvider: ViewModelProvider? = null  // 通信相关的ViewModel
    private var binding: ViewDataBinding? = null

    // 将DataBinding严格限制在基类中
    protected abstract fun getDataBindingConfig(): DataBindingConfig

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
        for (i in 0 until bindingParams.size()){
            dataBinding.setVariable(bindingParams.keyAt(0), bindingParams.valueAt(0))
        }
        this.binding = dataBinding
        val root = binding!!.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.unbind()
        binding = null
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
package com.zdy.android.app.loveandroid.base

import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.base.binding.DataBindingConfig

abstract class BaseActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName
    private var tvStrictModeTip: TextView? = null
    private var activityProvider: ViewModelProvider? = null
    private var applicationProvider: ViewModelProvider? = null
    private var binding: ViewDataBinding? = null

    protected abstract fun initViewModel()
    protected abstract fun getDataBindingConfig(): DataBindingConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        // 将所有DataBinding相关操作都提取到基类中
        val bindingConfig = getDataBindingConfig()
        val dataBinding =
            DataBindingUtil.setContentView<ViewDataBinding>(this, bindingConfig.layout)
        dataBinding.lifecycleOwner = this
        dataBinding.setVariable(bindingConfig.vmVariableId, bindingConfig.stateViewModel)
        val bindingParams = bindingConfig.bindingParams

        // 遍历dataBinding中的数据
        var index = 0
        val size = bindingParams.size()
        while(index < size) {
            dataBinding?.setVariable(bindingParams.keyAt(index), bindingParams.valueAt(index))
            ++index
        }
        this.binding = dataBinding
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.unbind()
        binding = null
    }

    protected fun <T : ViewModel> getActivityScopeViewModel(modelClass: Class<T>): T {
        if (activityProvider == null) activityProvider = ViewModelProvider(this)
        return activityProvider!![modelClass]
    }

    protected fun <T : ViewModel> getApplicationScopeViewModel(modelClass: Class<T>): T {
        if (applicationProvider == null)
            applicationProvider = ViewModelProvider(applicationContext as MyApplication)
        return applicationProvider!![modelClass]
    }

    protected fun getBinding(): ViewDataBinding? {
        if (isDebug() && binding != null && tvStrictModeTip == null) {
            tvStrictModeTip = TextView(applicationContext)
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
        application.applicationInfo != null && (application.applicationInfo.flags and 2) != 0
}
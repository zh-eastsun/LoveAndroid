package com.zdy.android.app.loveandroid.base.binding

import android.util.SparseArray
import androidx.lifecycle.ViewModel

/**
 * 与视图有关的参数集合
 */
class DataBindingConfig(
    _layout: Int,
    _vmVariableId: Int,
    _stateViewModel: ViewModel
) {
    var layout: Int = _layout
        private set
    var vmVariableId: Int = _vmVariableId
        private set
    var stateViewModel = _stateViewModel
        private set
    val bindingParams = SparseArray<Any>()

    fun addBindingParam(variableId: Int, param: Any): DataBindingConfig{
        if (bindingParams.get(variableId) == null)
            bindingParams.put(variableId, param)
        return this
    }
}
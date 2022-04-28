package com.zdy.android.app.loveandroid.ui.activity

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zdy.android.app.loveandroid.BR
import com.zdy.android.app.loveandroid.R
import com.zdy.android.app.loveandroid.ui.state.LauncherViewModel
import com.zdy.android.application.architecture.common.base.BaseActivity
import com.zdy.android.application.architecture.common.base.binding.DataBindingConfig

class LauncherActivity : BaseActivity() {

    private var stateViewModel: LauncherViewModel? = null

    override fun initViewModel() {
        stateViewModel = getActivityScopeViewModel(LauncherViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(
            R.layout.activity_launcher,
            BR.stateViewModel,
            stateViewModel!!,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navigation_content) as NavHostFragment
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view_launcher)
        bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }
}
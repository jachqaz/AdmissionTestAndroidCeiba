package com.admissiontest.ui.main

import androidx.activity.viewModels
import com.admissiontest.R
import com.admissiontest.databinding.ActivityMainBinding
import com.admissiontest.ui.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    lateinit var activityLoginBinding: ActivityMainBinding
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        activityLoginBinding = this.binding as ActivityMainBinding
        mainViewModel.getList()
    }
}

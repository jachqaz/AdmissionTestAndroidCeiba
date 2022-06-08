package com.admissiontest.ui.main

import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.admissiontest.R
import com.admissiontest.databinding.ActivityMainBinding
import com.admissiontest.domain.model.User
import com.admissiontest.ui.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    lateinit var activityMainBinding: ActivityMainBinding
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        activityMainBinding = this.binding as ActivityMainBinding
        initLiveData()
        mainViewModel.getList()
        val manager = LinearLayoutManager(this)
        activityMainBinding.rvUser.layoutManager = manager
    }

    private fun initLiveData() {
        mainViewModel.liveDataUser.observe(this) { users ->
            activityMainBinding.rvUser.adapter = MainAdapter(users ?: listOf(), object : MainAdapter.PostListener {
                override fun goToPostListener(user: User) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}

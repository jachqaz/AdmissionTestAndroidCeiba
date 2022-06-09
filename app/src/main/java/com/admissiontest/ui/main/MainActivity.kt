package com.admissiontest.ui.main

import android.view.View
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import com.admissiontest.R
import com.admissiontest.databinding.ActivityMainBinding
import com.admissiontest.domain.model.User
import com.admissiontest.ui.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(), MainUserAdapter.PostListener {
    private val mainViewModel: MainViewModel by viewModels()
    lateinit var activityMainBinding: ActivityMainBinding
    private var users = arrayListOf<User>()
    private var usersSearch = arrayListOf<User>()
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        activityMainBinding = this.binding as ActivityMainBinding
        initLiveData()
        initBinding()
        mainViewModel.getUsers()
    }

    private fun initBinding() {
        activityMainBinding.etSearch.doOnTextChanged { text, _, _, _ ->
            usersSearch = users.filter { user ->
                text?.let {
                    user.name.split(" ").first().lowercase().contains(it)
                } == true
            } as ArrayList<User>
            activityMainBinding.rvUser.adapter = MainUserAdapter(this, usersSearch)
            if (usersSearch.isEmpty()) {
                activityMainBinding.tvListEmpty.visibility = View.VISIBLE
            } else {
                activityMainBinding.tvListEmpty.visibility = View.GONE
            }
        }
    }

    private fun initLiveData() {
        mainViewModel.liveDataUser.observe(this) { data ->
            if (data != null) {
                users.addAll(data)
                usersSearch.addAll(data)
                activityMainBinding.rvUser.adapter = MainUserAdapter(this, usersSearch)
            }
        }
        mainViewModel.liveDataPost.observe(this) { data ->
            if (data != null) {
                activityMainBinding.rvUser.adapter = MainUserAdapter(this, usersSearch, data)
            }
        }
    }

    override fun goToPostListener(user: User) {
        mainViewModel.findPost(user.id)
    }
}

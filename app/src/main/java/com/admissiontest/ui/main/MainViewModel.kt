package com.admissiontest.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.admissiontest.domain.model.User
import com.admissiontest.domain.usecase.MainUseCase
import com.admissiontest.ui.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase) : BaseViewModel() {
    var liveDataUser = MutableLiveData<List<User>?>()
    var users = arrayListOf<User>()
    var usersSearch = arrayListOf<User>()
    fun getList() {
        viewModelScope.launch {
            liveDataUser.value = mainUseCase.getUsers()
        }
    }
}

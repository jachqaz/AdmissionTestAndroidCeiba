package com.admissiontest.ui.main

import androidx.lifecycle.viewModelScope
import com.admissiontest.domain.MainUseCase
import com.admissiontest.ui.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase) : BaseViewModel() {
//    var liveDataUserLogged = MutableLiveData<User>()

    fun getList() {
        viewModelScope.launch {
            mainUseCase.getUsers()
        }
    }
}

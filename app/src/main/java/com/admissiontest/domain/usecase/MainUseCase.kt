package com.admissiontest.domain.usecase

import com.admissiontest.data.api.MainApi
import com.admissiontest.domain.model.User
import javax.inject.Inject

class MainUseCase @Inject constructor(private val mainApi: MainApi) {
    suspend fun getUsers(): List<User>? {
        return mainApi.getUsers().body()
    }
}

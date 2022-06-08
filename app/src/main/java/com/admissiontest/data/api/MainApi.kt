package com.admissiontest.data.api

import com.admissiontest.data.api.interfaces.UserApi
import com.admissiontest.data.api.objects.ObjectRetrofit
import com.admissiontest.domain.model.User
import retrofit2.Response
import javax.inject.Inject

class MainApi @Inject constructor() {
    suspend fun getUsers(): Response<List<User>> {
        return ObjectRetrofit.getInstance().create(UserApi::class.java).getUsers()
    }

}

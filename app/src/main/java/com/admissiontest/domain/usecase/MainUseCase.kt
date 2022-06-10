package com.admissiontest.domain.usecase

import com.admissiontest.data.api.MainApi
import com.admissiontest.data.room.UserRepository
import com.admissiontest.domain.model.Post
import com.admissiontest.domain.model.User
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val mainApi: MainApi,
    private val userRepository: UserRepository
) {
    suspend fun getUsers(): List<User>? {
        var users = userRepository.getUsers()
        return mainApi.getUsers().body()

//        if(users.isEmpty()){
//        }else {
//            return mainApi.getUsers().body()
//        }
    }

    suspend fun getPosts(): List<Post>? {
        return mainApi.getPosts().body()
    }

    suspend fun findPost(userId: Long): List<Post>? {
        return mainApi.findPost(userId).body()
    }
}

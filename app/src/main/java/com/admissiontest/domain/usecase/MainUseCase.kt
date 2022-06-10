package com.admissiontest.domain.usecase

import com.admissiontest.data.api.MainApi
import com.admissiontest.data.room.PostRepository
import com.admissiontest.data.room.UserRepository
import com.admissiontest.domain.model.Post
import com.admissiontest.domain.model.User
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val mainApi: MainApi,
    private val userRepository: UserRepository,
    private val postRepository: PostRepository
) {
    suspend fun getUsers(): List<User>? {
        return userRepository.getUsers().ifEmpty {
            mainApi.getUsers().body()?.let { userRepository.insertAll(it) }
            mainApi.getUsers().body()
        }
    }

    suspend fun getPosts(): List<Post>? {
        return postRepository.getPosts().ifEmpty {
            mainApi.getPosts().body()?.let { postRepository.insertAll(it) }
            mainApi.getPosts().body()
        }
    }

    suspend fun findPost(userId: Long): List<Post>? {
        return postRepository.findPosts(userId).ifEmpty {
            mainApi.findPost(userId).body()?.let { postRepository.insertAll(it) }
            mainApi.findPost(userId).body()
        }
    }
}

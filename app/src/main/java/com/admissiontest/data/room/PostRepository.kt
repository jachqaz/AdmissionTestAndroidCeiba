/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.admissiontest.data.room

import com.admissiontest.domain.model.Post
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor(private val postDao: PostDao) {

    fun getPosts() = postDao.getAll()

    suspend fun insertAll(posts: List<Post>) {
        postDao.insertAll(posts)
    }

    fun findPosts(userId: Long) = postDao.findByUserId(userId.toInt())

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: PostRepository? = null

        fun getInstance(postDao: PostDao) =
            instance ?: synchronized(this) {
                instance ?: PostRepository(postDao).also { instance = it }
            }
    }
}

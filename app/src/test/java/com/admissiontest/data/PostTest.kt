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

package com.admissiontest.data

import com.admissiontest.domain.model.Post
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PostTest {

    private lateinit var post: Post

    @Before
    fun setUp() {
        post = Post(
            1,
            1,
            1,
            "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
        )
    }

    @Test
    fun test_default_values() {
        assertEquals(1, post.id)
        assertEquals(
            "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            post.title
        )
    }

}

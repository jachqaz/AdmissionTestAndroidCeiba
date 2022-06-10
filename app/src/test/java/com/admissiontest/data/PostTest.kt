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

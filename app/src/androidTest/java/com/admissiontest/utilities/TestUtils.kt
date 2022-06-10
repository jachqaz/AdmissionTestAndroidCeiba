package com.admissiontest.utilities

import com.admissiontest.domain.model.Post
import com.admissiontest.domain.model.User


val testUsers = arrayListOf(
    User(
        1,
        1,
        "Leanne Graham",
        "Bret",
        "Sincere@april.biz",
        "1-770-736-8031 x56442",
        "hildegard.org"
    )
)
val testUser = testUsers[0]

val testPosts = arrayListOf(
    Post(
        1,
        1,
        1,
        "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    )
)
val testPost = testPosts[0]


package com.admissiontest.data

import com.admissiontest.domain.model.User
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserTest {

    private lateinit var user: User

    @Before
    fun setUp() {
        user = User(
            1,
            1,
            "Leanne Graham",
            "Bret",
            "Sincere@april.biz",
            "1-770-736-8031 x56442",
            "hildegard.org"
        )
    }

    @Test
    fun test_default_values() {
        assertEquals(1, user.id)
        assertEquals("Leanne Graham", user.name)
    }

}

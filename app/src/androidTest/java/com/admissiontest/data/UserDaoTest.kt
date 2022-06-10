package com.admissiontest.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.admissiontest.data.room.AppDatabase
import com.admissiontest.data.room.UserDao
import com.admissiontest.utilities.testUser
import com.admissiontest.utilities.testUsers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        userDao = database.userDao()

        database.userDao().insertAll(testUsers)
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testUserDao() = runBlocking {
        assertEquals(database.userDao().getAll().first().id, testUser)
    }
}

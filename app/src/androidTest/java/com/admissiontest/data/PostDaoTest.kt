package com.admissiontest.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.admissiontest.data.room.AppDatabase
import com.admissiontest.data.room.PostDao
import com.admissiontest.utilities.testPost
import com.admissiontest.utilities.testPosts
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PostDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var postDao: PostDao

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        postDao = database.postDao()

        database.postDao().insertAll(testPosts)
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testpostDao() = runBlocking {
        assertEquals(database.postDao().getAll().first().id, testPost)
    }
}

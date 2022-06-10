package com.admissiontest.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    var userId: Long = 0,
    val id: Long? = 0,
    val name: String? = "",
    val username: String? = "",
    val email: String? = "",
    val phone: String? = "",
    val website: String? = "",
)

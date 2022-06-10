package com.admissiontest.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class Post(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "postId")
    var postId: Long = 0,
    var userId: Int?,
    var id: Int?,
    var title: String?,
    var body: String?,
)

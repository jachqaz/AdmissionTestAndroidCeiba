package com.admissiontest.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class Company(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var companyId: Long = 0,
    val name: String? = "",
    val catchPhrase: String? = "",
    val bs: String? = ""
)

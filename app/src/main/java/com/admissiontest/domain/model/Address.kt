package com.admissiontest.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class Address(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var addressId: Long = 0,
    val street: String? = "",
    val suite: String? = "",
    val city: String? = "",
    val zipcode: String? = "",
//    @Transient
//    val geo: Geo?,
)

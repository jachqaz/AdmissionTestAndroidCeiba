package com.admissiontest.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geo")
data class Geo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var geoId: Long = 0,
    val lat: String? = "",
    val lng: String? = ""
)

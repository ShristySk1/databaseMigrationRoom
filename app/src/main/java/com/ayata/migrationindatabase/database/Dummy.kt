package com.ayata.migrationindatabase.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dummy")
data class Dummy(
    val title: String?,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)
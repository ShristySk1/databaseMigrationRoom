package com.ayata.migrationindatabase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "note")
data class Note(
    val title: String?,
    val desc: String?,
    val test: String?,
    @ColumnInfo(name = "created_at", defaultValue = "CURRENT_TIMESTAMP")
    var createdDate: Date,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
//    var test2:String?
)
package com.ayata.migrationindatabase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail")
data class Detail(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val desc: String,
    val detail: String,
    val test_manunal_query: String,
    val again:String,
    val gain:String,
)
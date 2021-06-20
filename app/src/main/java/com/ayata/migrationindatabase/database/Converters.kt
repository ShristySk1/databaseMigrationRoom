package com.ayata.migrationindatabase.database

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestampToDate(value: Long?): Date? {
        return value?.let {
            Date(it)
        }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.getTime()
    }

    companion object {
        fun dateToString(d: Date): String {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.ENGLISH)
            return dateFormat.format(d)
        }
    }
}
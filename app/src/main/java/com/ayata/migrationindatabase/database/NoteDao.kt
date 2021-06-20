package com.ayata.migrationindatabase.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM note")
    fun getAll(): LiveData<List<Note>>

    @Query("SELECT * from note where created_at>:date")
    fun getNoteAfterToday(date: Date):LiveData<List<Note>>
}
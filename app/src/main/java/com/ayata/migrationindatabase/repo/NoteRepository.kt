package com.ayata.migrationindatabase.repo

import com.ayata.migrationindatabase.database.Note
import com.ayata.migrationindatabase.database.NoteDatabase
import java.util.*

class NoteRepository(private val database: NoteDatabase) {

    suspend fun insert(note: Note) {
        database.noteDao().insert(note)
    }

    fun getAll() = database.noteDao().getAll()
    fun getAllAfterToday(date: Date) = database.noteDao().getNoteAfterToday(date)

}
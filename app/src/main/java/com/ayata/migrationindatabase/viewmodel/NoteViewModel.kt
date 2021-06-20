package com.ayata.migrationindatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ayata.migrationindatabase.database.Note
import com.ayata.migrationindatabase.repo.NoteRepository
import kotlinx.coroutines.launch
import java.util.*

class NoteViewModel(
    app: Application,
    private val repository: NoteRepository
) : AndroidViewModel(app) {

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    fun getAll() = repository.getAll()
    fun getAfetrToday(date: Date) = repository.getAllAfterToday(date)

}
package com.ayata.migrationindatabase

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ayata.migrationindatabase.database.Note
import com.ayata.migrationindatabase.database.NoteDatabase
import com.ayata.migrationindatabase.databinding.ActivityMainBinding
import com.ayata.migrationindatabase.repo.NoteRepository
import com.ayata.migrationindatabase.viewmodel.NoteViewModel
import com.ayata.migrationindatabase.viewmodel.NoteViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

/**
 * Database is checked internally and cannot be viewed from app currently.
 * Only crash was checked during this upload.
 */
class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repo = NoteRepository(NoteDatabase.getDatabaseClient(this))
        val factory = NoteViewModelFactory(application, repo)
        noteViewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)

        val textToSave = binding.editTextTextPersonName.text
        //insert
//        val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
//        val new_date: String = dateFormat.format(Date)
//        val my_date = dateFormat.parse(new_date)

//        noteViewModel.insert(Note( "g", java.sql.Date(System.currentTimeMillis())))


        val date = Date();
        val now = SimpleDateFormat("dd/MM/yyyy").format(date)
//        val sDate1 = "31/12/2021"
        val todayDate = SimpleDateFormat("dd/MM/yyyy").parse(now)
//        noteViewModel.insert(Note("f", todayDate))

        noteViewModel.getAll().observe(this,
            { list ->
//                binding.editTextTextPersonName.setText(list.toString())
//                Log.d("test", "onCreate: " + list.get(2).createdDate);
//                Log.d("test", "onCreate: " + Converters.dateToString(list.get(2).createdDate));

            })
//        val dateformat = SimpleDateFormat("dd/MM/yyyy")
//        val start1: Date = dateformat.parse("17/06/2021")

        val specificString="10/06/2021"
        val specificDate=SimpleDateFormat("dd/MM/yyyy").parse(specificString)

        noteViewModel.getAfetrToday(specificDate).observe(this, {
            for (i in it)
                Log.d("test", "onCreate: " + (i).createdDate);

        })

    }
}
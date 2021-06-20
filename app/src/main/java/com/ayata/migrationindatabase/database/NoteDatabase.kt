package com.ayata.migrationindatabase.database

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//auto migration( add new table)
@Database(
    version = 2,
    entities = [Note::class, Detail::class, Dummy::class],
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
    ],
    exportSchema = true
)
//manual migration(add new column)
//@Database(
//    version = 7,
//    entities = [Note::class, Detail::class],
//    exportSchema = false
//)
@TypeConverters(Converters::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    //create database
    companion object {
        val MIGRATION_6_7 = object : Migration(6, 7) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE 'detail' ADD COLUMN 'gain' TEXT NOT NULL DEFAULT 'NULL'"
                )
            }
        }

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabaseClient(context: Context): NoteDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, NoteDatabase::class.java, "NOTE_DATABASE")
//                    .addMigrations(MIGRATION_6_7)
                    .build()

                return INSTANCE!!

            }
        }

    }
}
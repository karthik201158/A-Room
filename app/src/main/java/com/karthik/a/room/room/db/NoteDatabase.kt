package com.karthik.a.room.room.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.karthik.a.room.model.Note
import com.karthik.a.room.utils.Converters
import com.karthik.a.room.room.dao.NoteDao


@Database(
    entities = [Note::class],
    version = 2,//changed from 1 to 2
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ],
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun appDao(): NoteDao
}
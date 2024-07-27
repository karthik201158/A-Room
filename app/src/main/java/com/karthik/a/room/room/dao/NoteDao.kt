package com.karthik.a.room.room.dao

import androidx.room.*
import com.karthik.a.room.model.Note
import kotlinx.coroutines.flow.Flow
import com.karthik.a.room.utils.MyAppConstants.TABLE_NAME

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

   //To get all registered users
    @Query("SELECT * FROM Note")
     fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun getNote(id: Int): Note

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}
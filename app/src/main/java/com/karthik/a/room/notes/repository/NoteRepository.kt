package com.karthik.a.room.notes.repository


import com.karthik.a.room.model.Note
import kotlinx.coroutines.flow.Flow


interface NoteRepository {
    fun getAllNotes():  Flow<List<Note>>

    suspend fun getNote(id: Int): Note

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)
}
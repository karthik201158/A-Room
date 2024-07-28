package com.karthik.a.room.notes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karthik.a.room.notes.repository.NoteRepository
import com.karthik.a.room.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

   fun getAllNotes(){
       viewModelScope.launch {
           noteRepository.getAllNotes()
               .flowOn(Dispatchers.IO)
               .catch { e ->
                   // handle exception

               }
               .collect {
                   // list of users from the network
                   it.forEach { Log.d("VerifyDataWorker", "Note: ${it.title}, Content: ${it.description}") }
               }
       }
   }

    fun addNote(note: Note){
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

}
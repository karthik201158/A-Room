package com.karthik.a.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.karthik.a.room.model.Note
import com.karthik.a.room.model.NoteEmbedded
import com.karthik.a.room.notes.NoteViewModel
import com.karthik.a.room.ui.theme.ARoomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARoomTheme {

            }
        }
        addDummyNote()
        verifyData()
    }

    fun addDummyNote(){
        // Insert dummy data
        val note = Note(
            id =1,
            title = "Note 1",
            description = "This is the content of note 1",
            emb =NoteEmbedded(designation = "Backend")
        )
        viewModel.addNote(note)
    }

    fun verifyData(){
        viewModel.getAllNotes()
    }
}
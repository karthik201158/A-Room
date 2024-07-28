package com.karthik.a.room.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.karthik.a.room.utils.MyAppConstants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val timestamp: Long,//New column
    @Embedded val emb:NoteEmbedded
)


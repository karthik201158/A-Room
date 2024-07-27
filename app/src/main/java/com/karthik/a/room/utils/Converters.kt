package com.karthik.a.room.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.karthik.a.room.model.NoteCustom


class Converters {
    private val gson = Gson()
    @TypeConverter
    fun fromNoteCustom(custom: NoteCustom):String{
      return gson.toJson(custom)
    }

    @TypeConverter
    fun toNoteCustom(json:String):NoteCustom{
     return gson.fromJson(json, NoteCustom::class.java)
    }
}


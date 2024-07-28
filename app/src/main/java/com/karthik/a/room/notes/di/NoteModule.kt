package com.karthik.a.room.notes.di

import com.karthik.a.room.notes.repository.NoteRepository
import com.karthik.a.room.notes.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class NoteModule {

    @Binds
    abstract fun bindNoteInterface(
        noteRepositoryImpl: NoteRepositoryImpl
    ): NoteRepository
}
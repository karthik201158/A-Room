package com.karthik.a.room.utils

import android.content.Context
import androidx.room.Room
import com.karthik.a.room.room.Migrations
import com.karthik.a.room.room.dao.NoteDao
import com.karthik.a.room.room.db.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    /*Now we are telling hilt to provide instance of database*/
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): NoteDatabase {
        return Room.databaseBuilder(
            appContext,
            NoteDatabase::class.java,
            MyAppConstants.DATABASE_NAME
        )
        .addMigrations(Migrations.MIGRATION_1_2)
         .build()
    }

    /*Now we are telling hilt to provide instance of dao*/
    @Provides
    fun provideAppDatabaseDao(appDatabase: NoteDatabase): NoteDao {
        return appDatabase.appDao()
    }
}
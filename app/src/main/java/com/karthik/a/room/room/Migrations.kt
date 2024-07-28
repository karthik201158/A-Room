package com.karthik.a.room.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


object Migrations {
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("ALTER TABLE Note ADD COLUMN timestamp INTEGER DEFAULT 0 NOT NULL")
        }
    }
}

package com.splhead.devotional.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.splhead.devotional.data.Devotional

@Database(version = 1, entities = [Devotional::class])
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "devotional.db")
                        .allowMainThreadQueries()
                        .build()
    }

    abstract fun DevotionalDAO(): DevotionalDAO
}

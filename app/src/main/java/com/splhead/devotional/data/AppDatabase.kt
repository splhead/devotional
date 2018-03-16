package com.splhead.devotional.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.splhead.devotional.Devotional

@Database(version = 1, entities = [Devotional::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun DevotionalDAO(): DevotionalDAO
}

package com.splhead.devotional.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.splhead.devotional.Devotional
import java.util.*


@Dao
interface DevotionalDAO {

    @Query("SELECT * FROM devotional WHERE date = :date")
    fun getDevotionalsOfDay(date: Date): List<Devotional>

    @Insert
    fun insertDevotional(devotional: Devotional)


}
package com.splhead.devotional.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.splhead.devotional.Devotional


@Dao
interface DevotionalDAO {

    @Query("SELECT * FROM devotional WHERE date = :date")
    fun findDevotionalsByDate(date: String)

    @Insert
    fun addDevotional(devotional: Devotional)


}
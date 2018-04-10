package com.splhead.devotional.data.database

import com.splhead.devotional.data.Devotional
import java.util.*


interface DevotionalDataSource {
    fun getDevotionalsOfDay(date: Date): List<Devotional>

    fun insertDevotional(devotional: Devotional)
}
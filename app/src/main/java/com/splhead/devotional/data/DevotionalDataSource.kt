package com.splhead.devotional.data

import com.splhead.devotional.Devotional
import java.util.*


interface DevotionalDataSource {
    fun getDevotionalsOfDay(date: Date): List<Devotional>

    fun insertDevotional(devotional: Devotional)
}
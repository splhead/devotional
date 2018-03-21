package com.splhead.devotional.data

import com.splhead.devotional.Devotional


interface DevotionalDataSource {
    fun getDevotionalsOfDay(date: String): List<Devotional>

    fun insertDevotional(devotional: Devotional)
}
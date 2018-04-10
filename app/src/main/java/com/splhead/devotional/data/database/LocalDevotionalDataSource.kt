package com.splhead.devotional.data.database

import android.content.Context
import com.splhead.devotional.data.Devotional
import java.util.*


class LocalDevotionalDataSource(private val devotionalDAO: DevotionalDAO) : DevotionalDataSource {
    companion object {

        @Volatile
        private var INSTANCE: LocalDevotionalDataSource? = null

        fun getInstance(context: Context): LocalDevotionalDataSource =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: getLocalDataSource(context).also { INSTANCE = it }
                }

        private fun getLocalDataSource(context: Context) =
                LocalDevotionalDataSource(AppDatabase.getInstance(context).DevotionalDAO())
    }

    override fun getDevotionalsOfDay(date: Date): List<Devotional> {
        return devotionalDAO.getDevotionalsOfDay(date)
    }

    override fun insertDevotional(devotional: Devotional) {
        devotionalDAO.insertDevotional(devotional)
    }

}
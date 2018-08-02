package com.splhead.devotional

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.splhead.devotional.data.Devotional
import com.splhead.devotional.data.database.AppDatabase
import com.splhead.devotional.data.database.LocalDevotionalDataSource
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class LocalDevotionalDataSourceTest {
    private lateinit var devotional: Devotional

//    private lateinit var mDatabase: AppDatabase
    private lateinit var mDataSource: LocalDevotionalDataSource

    private val context = InstrumentationRegistry.getTargetContext()

    @Before
    @Throws(Exception::class)
    fun initDataSource() {
        val date = Date(Calendar.getInstance().timeInMillis)
        devotional = Devotional("title", "verse",
                date, "text", 1)
        /*mDatabase = Room.inMemoryDatabaseBuilder(
                context,
                AppDatabase::class.java
        ).build()

        mDataSource = LocalDevotionalDataSource(mDatabase.DevotionalDAO())*/
        mDataSource = LocalDevotionalDataSource.getInstance(context)
    }

    @Test
    fun insertDevotional() {
        mDataSource.insertDevotional(devotional)

        val dbDevotional = mDataSource.getDevotionalsOfDay(devotional.date)
        assertEquals(dbDevotional[0].title, devotional.title)

    }

    /* @After
     @Throws(Exception::class)
     fun closeDb() {
         mDatabase.close()
     }*/
}

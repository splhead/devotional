package com.splhead.devotional

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.splhead.devotional.data.LocalDevotionalDataSource
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LocalDevotionalDataSourceTest {
    private val devotional = Devotional("title", "verse",
            "2018-01-01", "text", 1)

    //    private lateinit var mDatabase: AppDatabase
    private lateinit var mDataSource: LocalDevotionalDataSource

    private val context = InstrumentationRegistry.getTargetContext()

    @Before
    @Throws(Exception::class)
    fun initDataSource() {
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

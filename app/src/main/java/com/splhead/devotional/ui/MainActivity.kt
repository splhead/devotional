package com.splhead.devotional.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.splhead.devotional.AndroidApplication
import com.splhead.devotional.R
import com.splhead.devotional.data.Devotional
import com.splhead.devotional.data.database.DevotionalDataSource
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var devotionalDataSource: DevotionalDataSource


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val date = Date(Calendar.getInstance().timeInMillis)
        val devotional = Devotional("title", "verse",
                date, "text", 4)

        AndroidApplication.component.inject(this)
        devotionalDataSource.insertDevotional(devotional)

        val devotionals = devotionalDataSource.getDevotionalsOfDay(date)

        Log.d(TAG, devotionals.toString())
    }
}

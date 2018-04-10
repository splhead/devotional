package com.splhead.devotional.di


import android.content.Context
import com.splhead.devotional.AndroidApplication
import com.splhead.devotional.data.database.DevotionalDataSource
import com.splhead.devotional.data.database.LocalDevotionalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideDevotionalDataSource(context: Context): DevotionalDataSource =
            LocalDevotionalDataSource.getInstance(context)

}
package com.splhead.devotional

import android.app.Application
import com.splhead.devotional.di.AppComponent
import com.splhead.devotional.di.AppModule
import com.splhead.devotional.di.DaggerAppComponent

class AndroidApplication : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        component = DaggerAppComponent
                .builder()
                .appModule(AppModule(this)) // the magic dagger
                .build()
    }
}
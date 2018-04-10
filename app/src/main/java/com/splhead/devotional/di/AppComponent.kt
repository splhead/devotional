package com.splhead.devotional.di

import com.splhead.devotional.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(activity: MainActivity)
}
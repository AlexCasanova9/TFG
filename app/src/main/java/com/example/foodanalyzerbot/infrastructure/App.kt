package com.example.foodanalyzerbot.infrastructure

import android.app.Application
import com.example.foodanalyzerbot.presentation.common.navigation.Navigator
import com.example.foodanalyzerbot.presentation.common.navigation.NavigatorImpl

class App : Application() {

    companion object {
        private lateinit var navigator: Navigator

        fun getNavigator() = navigator
    }

    override fun onCreate() {
        super.onCreate()
        navigator = NavigatorImpl(applicationContext)
    }

}
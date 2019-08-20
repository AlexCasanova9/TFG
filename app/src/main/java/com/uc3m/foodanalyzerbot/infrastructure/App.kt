package com.uc3m.foodanalyzerbot.infrastructure

import android.app.Application
import com.uc3m.foodanalyzerbot.presentation.common.navigation.Navigator
import com.uc3m.foodanalyzerbot.presentation.common.navigation.NavigatorImpl

class App : Application() {

    companion object {
        private lateinit var navigator: Navigator

        fun getNavigator() = navigator

        lateinit var user:String
        const val botUser = "Fudy"
    }

    override fun onCreate() {
        super.onCreate()
        navigator = NavigatorImpl(applicationContext)
    }

}
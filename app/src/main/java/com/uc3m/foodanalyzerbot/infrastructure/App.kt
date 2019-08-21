package com.uc3m.foodanalyzerbot.infrastructure

import android.app.Application
import android.content.Context
import com.uc3m.foodanalyzerbot.presentation.common.navigation.Navigator
import com.uc3m.foodanalyzerbot.presentation.common.navigation.NavigatorImpl

class App : Application() {

    companion object {
        private lateinit var navigator: Navigator

        fun getNavigator() = navigator

        fun initializeNavigator(context: Context) {
            navigator = NavigatorImpl(context)
        }

        lateinit var user:String
        const val botUser = "Fudy"
    }


}
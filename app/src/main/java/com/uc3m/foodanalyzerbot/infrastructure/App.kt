package com.uc3m.foodanalyzerbot.infrastructure

import android.app.Application
import android.content.Context
import android.support.v4.app.FragmentActivity
import com.uc3m.foodanalyzerbot.data.service.PreferenceServiceImpl
import com.uc3m.foodanalyzerbot.domain.service.PreferenceService
import com.uc3m.foodanalyzerbot.presentation.common.navigation.Navigator
import com.uc3m.foodanalyzerbot.presentation.common.navigation.NavigatorImpl

class App : Application() {

    companion object {
        private lateinit var navigator: Navigator

        fun getNavigator() = navigator

        fun initializeNavigator(context: Context) {
            navigator = NavigatorImpl(context)
        }

        private lateinit var preferences: PreferenceService

        fun getPreferences() = preferences

        fun initializePreferences(context: FragmentActivity) {
            preferences = PreferenceServiceImpl(context)
        }

        const val botUser = "Fudy"
    }


}
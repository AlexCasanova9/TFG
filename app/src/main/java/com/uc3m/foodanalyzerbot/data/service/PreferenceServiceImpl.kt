package com.uc3m.foodanalyzerbot.data.service

import android.support.annotation.Keep
import android.support.v4.app.FragmentActivity
import com.uc3m.foodanalyzerbot.domain.service.PreferenceService

class PreferenceServiceImpl(context: FragmentActivity) : BasePreferencesService(context),
    PreferenceService {

    override fun setBackgroundId(id: Int) {
        setInt(Key.BACKGROUND_ID, id)
    }

    override fun getBackgroundId(): Int {
        return getInt(Key.BACKGROUND_ID, 0)
    }

    override fun setUserName(name: String) {
        setString(Key.USER_NAME, name)
    }

    override fun getUserName(): String {
        return getString(Key.USER_NAME)
    }

    @Keep
    private enum class Key : PreferencesKey {
        BACKGROUND_ID,
        USER_NAME;

        override fun keyString(): String {
            return this.name
        }
    }
}
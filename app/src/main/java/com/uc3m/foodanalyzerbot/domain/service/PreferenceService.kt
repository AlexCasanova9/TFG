package com.uc3m.foodanalyzerbot.domain.service

interface PreferenceService {
    fun setBackgroundId(id: Int)

    fun getBackgroundId(): Int
}
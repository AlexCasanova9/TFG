package com.uc3m.foodanalyzerbot.data.repository.datasources.api.common

interface ApiClientGenerator {
    fun <T> generatedApi(service: Class<T>): T
}
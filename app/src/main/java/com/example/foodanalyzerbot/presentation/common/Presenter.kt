package com.example.foodanalyzerbot.presentation.common

interface Presenter<T : BaseView> {
    fun initialize(view: T)
}
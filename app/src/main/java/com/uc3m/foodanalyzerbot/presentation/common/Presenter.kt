package com.uc3m.foodanalyzerbot.presentation.common

interface Presenter<T : BaseView> {
    fun initialize(view: T)
}
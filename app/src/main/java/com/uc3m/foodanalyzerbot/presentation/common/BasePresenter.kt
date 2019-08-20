package com.uc3m.foodanalyzerbot.presentation.common

abstract class BasePresenter<T : BaseView> : Presenter<T> {
    protected var view: T? = null

    override fun initialize(view: T) {
        this.view = view
    }
}
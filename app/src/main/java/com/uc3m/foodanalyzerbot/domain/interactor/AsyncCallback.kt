package com.uc3m.foodanalyzerbot.domain.interactor


interface AsyncCallback<in T> {

    fun onSuccess(result: T)

    fun onError(t: Throwable)
}
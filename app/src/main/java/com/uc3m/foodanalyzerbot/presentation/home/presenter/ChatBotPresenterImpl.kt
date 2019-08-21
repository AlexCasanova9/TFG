package com.uc3m.foodanalyzerbot.presentation.home.presenter

import com.uc3m.foodanalyzerbot.infrastructure.App
import com.uc3m.foodanalyzerbot.presentation.common.BasePresenter
import com.uc3m.foodanalyzerbot.presentation.home.view.ChatBotView
import java.util.*

class ChatBotPresenterImpl : ChatBotPresenter, BasePresenter<ChatBotView>() {

    override fun onClickPButton() {
        App.getNavigator().showMessageRoom()
    }

    override fun onClickRandomWallpaper() {
        view?.setBackgroundImage(randomNumber())
    }

    override fun loadRandomBackground() {
        view?.setBackgroundImage(randomNumber())
    }

    private fun randomNumber(): Int {
        val r = Random()
        return r.nextInt(5) + 1
    }
}
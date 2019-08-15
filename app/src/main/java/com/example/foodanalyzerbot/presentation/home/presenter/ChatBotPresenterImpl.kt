package com.example.foodanalyzerbot.presentation.home.presenter

import com.example.foodanalyzerbot.infrastructure.App
import com.example.foodanalyzerbot.presentation.common.BasePresenter
import com.example.foodanalyzerbot.presentation.home.view.ChatBotView
import java.util.*

class ChatBotPresenterImpl : ChatBotPresenter, BasePresenter<ChatBotView>() {

    override fun onClickPButton() {
        App.getNavigator().showChat()
    }

    override fun onClickRandomWallpaper() {
        view?.setBackgroundImage(randomNumber())
    }

    override fun loadRandomBackground() {
        view?.setBackgroundImage(randomNumber())
    }

    private fun randomNumber(): Int {
        val r = Random()
        return r.nextInt(5)
    }
}
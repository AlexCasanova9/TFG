package com.example.foodanalyzerbot.presentation.home.presenter

import com.example.foodanalyzerbot.presentation.common.BasePresenter
import com.example.foodanalyzerbot.presentation.home.view.ChatBotView
import java.util.*

class ChatBotPresenterImpl : ChatBotPresenter, BasePresenter<ChatBotView>() {

    override fun onClickRandomWallpaper() {
        val r = Random()
        val number = r.nextInt(5) + 1
        view?.setBackgroundImage(number)
    }
}
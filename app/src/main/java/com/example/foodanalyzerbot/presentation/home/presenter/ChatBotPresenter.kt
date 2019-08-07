package com.example.foodanalyzerbot.presentation.home.presenter

import com.example.foodanalyzerbot.presentation.common.Presenter
import com.example.foodanalyzerbot.presentation.home.view.ChatBotView

interface ChatBotPresenter : Presenter<ChatBotView> {
    fun onClickRandomWallpaper()
}
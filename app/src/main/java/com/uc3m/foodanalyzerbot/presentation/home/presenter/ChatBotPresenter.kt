package com.uc3m.foodanalyzerbot.presentation.home.presenter

import com.uc3m.foodanalyzerbot.presentation.common.Presenter
import com.uc3m.foodanalyzerbot.presentation.home.view.ChatBotView

interface ChatBotPresenter : Presenter<ChatBotView> {
    fun onClickPButton()

    fun onClickRandomWallpaper()

    fun loadRandomBackground()
}
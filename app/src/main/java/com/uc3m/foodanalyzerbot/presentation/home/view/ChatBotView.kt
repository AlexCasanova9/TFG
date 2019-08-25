package com.uc3m.foodanalyzerbot.presentation.home.view

import com.uc3m.foodanalyzerbot.presentation.common.BaseView

interface ChatBotView : BaseView {

    fun setBackgroundImage(resource: Int)

    fun showMessage(message: String)
}
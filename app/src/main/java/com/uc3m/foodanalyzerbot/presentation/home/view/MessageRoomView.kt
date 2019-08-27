package com.uc3m.foodanalyzerbot.presentation.home.view

import com.uc3m.foodanalyzerbot.presentation.common.BaseView
import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto

interface MessageRoomView : BaseView {

    fun showMessage(message: MessageDto)
}
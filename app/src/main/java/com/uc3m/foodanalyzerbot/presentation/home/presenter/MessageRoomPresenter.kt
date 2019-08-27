package com.uc3m.foodanalyzerbot.presentation.home.presenter

import com.uc3m.foodanalyzerbot.presentation.common.Presenter
import com.uc3m.foodanalyzerbot.presentation.home.view.MessageRoomView

interface MessageRoomPresenter : Presenter<MessageRoomView> {
    fun onClickSend(message: String)

}
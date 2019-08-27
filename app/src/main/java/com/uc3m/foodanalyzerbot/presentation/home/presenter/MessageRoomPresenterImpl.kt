package com.uc3m.foodanalyzerbot.presentation.home.presenter

import android.widget.Toast
import com.uc3m.foodanalyzerbot.domain.interactor.InteractorCallback
import com.uc3m.foodanalyzerbot.domain.interactor.dialogFlow.DialogFlowAsyncInteractor
import com.uc3m.foodanalyzerbot.presentation.common.BasePresenter
import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto
import com.uc3m.foodanalyzerbot.presentation.home.view.MessageRoomView

class MessageRoomPresenterImpl : MessageRoomPresenter, BasePresenter<MessageRoomView>()  {

    private val dialogFlowInteractor = DialogFlowAsyncInteractor()

    override fun onClickSend(message: String) {

        dialogFlowInteractor.execute(message, object : InteractorCallback<MessageDto> {
            override fun success(data: MessageDto?) {
                if (data != null && data.message.isNotEmpty())
                    view?.showMessage(data)
            }

            override fun fail(t: Throwable?) {
                //Fail: Do what ever
            }
        })
    }
}
package com.uc3m.foodanalyzerbot.presentation.home.presenter

import com.uc3m.foodanalyzerbot.domain.interactor.InteractorCallback
import com.uc3m.foodanalyzerbot.domain.interactor.dialogFlow.DialogFlowAsyncInteractor
import com.uc3m.foodanalyzerbot.infrastructure.App
import com.uc3m.foodanalyzerbot.presentation.common.BasePresenter
import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto
import com.uc3m.foodanalyzerbot.presentation.home.view.ChatBotView
import java.util.*

class ChatBotPresenterImpl : ChatBotPresenter, BasePresenter<ChatBotView>() {

    private val dialogFlowInteractor = DialogFlowAsyncInteractor()

    override fun onClickPButton() {

        if(App.getPreferences().getUserName().isNotEmpty()){
            App.getNavigator().showMessageRoom()
        }
        else{
            App.getNavigator().showInputNameDialog()
        }
    }

    override fun onClickRandomWallpaper() {
        dialogFlowInteractor.execute("Hola", object : InteractorCallback<MessageDto> {
            override fun success(data: MessageDto?) {
                if (data != null && data.message.isNotEmpty())
                    view?.showMessage(data.message)
                else
                    view?.showMessage("Mensaje vacío")
            }

            override fun fail(t: Throwable?) {
                //Fail: Do what ever
            }
        })
        //view?.setBackgroundImage(randomNumber())
    }

    override fun loadRandomBackground() {
        view?.setBackgroundImage(randomNumber())
    }

    private fun randomNumber(): Int {
        val r = Random()
        return r.nextInt(5)
    }
}
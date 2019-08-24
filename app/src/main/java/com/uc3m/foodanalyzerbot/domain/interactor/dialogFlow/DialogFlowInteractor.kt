package com.uc3m.foodanalyzerbot.domain.interactor.dialogFlow

import com.uc3m.foodanalyzerbot.domain.interactor.Interactor
import com.uc3m.foodanalyzerbot.domain.interactor.InteractorCallback
import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto

interface DialogFlowInteractor : Interactor {

    fun execute(message: String, callback: InteractorCallback<MessageDto>)
}
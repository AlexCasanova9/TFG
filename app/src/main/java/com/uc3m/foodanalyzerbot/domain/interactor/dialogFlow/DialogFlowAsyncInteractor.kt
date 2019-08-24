package com.uc3m.foodanalyzerbot.domain.interactor.dialogFlow

import com.uc3m.foodanalyzerbot.data.repository.DialogFlowSimpleRepository
import com.uc3m.foodanalyzerbot.domain.interactor.AsyncTaskInteractor
import com.uc3m.foodanalyzerbot.domain.interactor.InteractorCallback
import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto

class DialogFlowAsyncInteractor : AsyncTaskInteractor<MessageDto>(), DialogFlowInteractor {

    private val repository = DialogFlowSimpleRepository()

    override fun execute(message: String, callback: InteractorCallback<MessageDto>) {
        execute(callback, message)
    }

    override fun runInBackground(vararg params: Any?): MessageDto {
        val message = params[0] as String
        return repository.getAnswer(message)
    }
}
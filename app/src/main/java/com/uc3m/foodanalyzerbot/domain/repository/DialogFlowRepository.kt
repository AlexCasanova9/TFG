package com.uc3m.foodanalyzerbot.domain.repository

import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto

interface DialogFlowRepository {

    fun getAnswer(messageToSend: String): MessageDto
}
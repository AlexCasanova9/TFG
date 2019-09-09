package com.uc3m.foodanalyzerbot.data.repository

import com.uc3m.foodanalyzerbot.data.repository.datasources.api.RetrofitDialogFlowApiClientGenerator
import com.uc3m.foodanalyzerbot.data.repository.datasources.api.dialogflow.DialogFlowApi
import com.uc3m.foodanalyzerbot.data.repository.datasources.api.dialogflow.model.DialogFlowApiResponse
import com.uc3m.foodanalyzerbot.domain.FullfilmentMessage
import com.uc3m.foodanalyzerbot.domain.repository.DialogFlowRepository
import com.uc3m.foodanalyzerbot.infrastructure.App
import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto
import java.util.*

class DialogFlowSimpleRepository : BaseRepository(), DialogFlowRepository {

    companion object {
        private const val PROTOCOL = "20170712"
        private const val SESSION_ID = 10
        private const val LANGUAGE = "es"
    }

    private val retrofitClientGenerator = RetrofitDialogFlowApiClientGenerator()

    override fun getAnswer(messageToSend: String): MessageDto {
        val api = retrofitClientGenerator.generatedApi(DialogFlowApi::class.java)
        val call = api.getAnswer(PROTOCOL, SESSION_ID, LANGUAGE, messageToSend)
        val response = executeCall(call)

        return buildMessageDto(response)
    }

    private fun buildMessageDto(response: DialogFlowApiResponse): MessageDto {
        return MessageDto(
            App.botUser,
            buildMessageText(
                response.result?.fullfillment?.message ?: "",
                response.result?.fullfillment?.messageList ?: emptyList()
            ),
            Calendar.getInstance().time.time
        )
    }

    private fun buildMessageText(speech: String, messageList: List<FullfilmentMessage>): String {
        return if (speech.isNotBlank()) {
            speech
        } else if (!messageList.isNullOrEmpty()) {
            var messagesConcat = ""
            messageList.forEach {
                messagesConcat = messagesConcat + it.text + "\n"
            }
            if (speech.isNotBlank())
                speech + "\n" + messagesConcat
            else
                messagesConcat
        } else {
            ""
        }
    }
}
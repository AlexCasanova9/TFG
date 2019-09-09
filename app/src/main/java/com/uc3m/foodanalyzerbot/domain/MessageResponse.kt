package com.uc3m.foodanalyzerbot.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MessageResponse(
    @SerializedName("speech") val message: String = "",
    @SerializedName("messages") val messageList: List<FullfilmentMessage> = emptyList()
) : Serializable
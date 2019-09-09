package com.uc3m.foodanalyzerbot.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class FullfilmentMessage(
    @SerializedName("speech") val text: String = ""
) : Serializable
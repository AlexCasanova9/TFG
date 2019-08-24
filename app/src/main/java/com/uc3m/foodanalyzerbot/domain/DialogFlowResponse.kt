package com.uc3m.foodanalyzerbot.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DialogFlowResponse(
    @SerializedName("fulfillment") val fullfillment: MessageResponse?
) : Serializable
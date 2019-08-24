package com.uc3m.foodanalyzerbot.data.repository.datasources.api.dialogflow.model

import com.google.gson.annotations.SerializedName
import com.uc3m.foodanalyzerbot.domain.DialogFlowResponse
import java.io.Serializable

class DialogFlowApiResponse(
    @SerializedName("result") val result: DialogFlowResponse?
) : Serializable
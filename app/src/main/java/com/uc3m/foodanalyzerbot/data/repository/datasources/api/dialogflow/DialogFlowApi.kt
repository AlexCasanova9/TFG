package com.uc3m.foodanalyzerbot.data.repository.datasources.api.dialogflow

import com.uc3m.foodanalyzerbot.data.repository.datasources.api.dialogflow.model.DialogFlowApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DialogFlowApi {

    @GET("query")
    fun getAnswer(
        @Query("v") protocol: String,
        @Query("sessionId") sessionId: Int,
        @Query("lang") language: String,
        @Query("query") message: String
    ): Call<DialogFlowApiResponse>
}
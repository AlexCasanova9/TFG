package com.uc3m.foodanalyzerbot.presentation.home.model

data class MessageDto(
    var user: String,
    var message: String,
    var time: Long
)
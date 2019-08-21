package com.uc3m.foodanalyzerbot.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

class Formatter {

    companion object {

        fun formatHour(millis: Long): String {
            val format = SimpleDateFormat("hh:mm a", Locale.getDefault())
            return format.format(millis)
        }

    }

}
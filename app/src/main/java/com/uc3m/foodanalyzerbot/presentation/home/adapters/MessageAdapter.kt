package com.uc3m.foodanalyzerbot.presentation.home.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.uc3m.foodanalyzerbot.R
import com.uc3m.foodanalyzerbot.infrastructure.App
import com.uc3m.foodanalyzerbot.presentation.home.model.MessageDto
import com.uc3m.foodanalyzerbot.presentation.utils.Formatter
import kotlinx.android.synthetic.main.item_message_bot.view.*
import kotlinx.android.synthetic.main.item_message_person.view.*
import java.util.*

class MessageAdapter(private val context: Context) : RecyclerView.Adapter<MessageViewHolder>() {

    companion object {
        private const val VIEW_TYPE_PERSON_MESSAGE = 1
        private const val VIEW_TYPE_BOT_MESSAGE = 2
    }

    private val messages: ArrayList<MessageDto> = ArrayList()


    fun addMessage(message: MessageDto) {
        messages.add(message)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(position: Int): Int {
        val message = messages[position]

        return if(App.user == message.user) {
            VIEW_TYPE_PERSON_MESSAGE
        } else {
            VIEW_TYPE_BOT_MESSAGE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return if (viewType == VIEW_TYPE_PERSON_MESSAGE) {
            MyMessageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message_person, parent, false))
        } else {
            BotMessageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message_bot, parent, false))
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.bind(message)
    }

    inner class MyMessageViewHolder (view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.UserText
        private var timeText: TextView = view.UserTime

        override fun bind(message: MessageDto) {
            messageText.text = message.message
            timeText.text = Formatter.formatHour(message.time)
        }
    }


    inner class BotMessageViewHolder (view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.BotText
        private var userText: TextView = view.BotName
        private var timeText: TextView = view.BotTime

        override fun bind(message: MessageDto) {
            messageText.text = message.message
            userText.text = message.user
            timeText.text = Formatter.formatHour(message.time)
        }
    }
}

open class MessageViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(message: MessageDto) = Unit
}

